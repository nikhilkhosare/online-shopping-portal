import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.sql.*;
import com.sun.net.httpserver.*;

public class OnlineShoppingServer {

    // 🔥 Updated DB connection
    static final String URL = "jdbc:mysql://127.0.0.1:3306/shopping_portal";
    static final String USER = "root";
    static final String PASSWORD = "Nikhil@1234";   // Put your MySQL password if any

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // PRODUCTS API
        server.createContext("/products", exchange -> {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");

            String response = getProducts();

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        // Serve static files
        server.createContext("/", exchange -> {

            String path = exchange.getRequestURI().getPath();
            if (path.equals("/")) {
                path = "/index.html";
            }

            File file = new File("." + path);

            if (!file.exists()) {
                exchange.sendResponseHeaders(404, -1);
                return;
            }

            byte[] bytes = Files.readAllBytes(file.toPath());
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        });

        server.start();
        System.out.println("🚀 Server started at http://localhost:8080");
    }

    public static String getProducts() {

        StringBuilder json = new StringBuilder();
        json.append("[");

        try {
            System.out.println("Connecting to database...");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected successfully!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;

                System.out.println("Product found: " + rs.getString("name"));

                json.append("{")
                        .append("\"id\":").append(rs.getInt("id")).append(",")
                        .append("\"name\":\"").append(rs.getString("name")).append("\",")
                        .append("\"price\":").append(rs.getDouble("price"))
                        .append("},");
            }

            if (hasData && json.charAt(json.length() - 1) == ',') {
                json.deleteCharAt(json.length() - 1);
            }

            json.append("]");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }

        return json.toString();
    }
}