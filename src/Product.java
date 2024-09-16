public class Product {

    private String id;
    private String name;
    private String description;
    private double cost;

    public Product(String id, String name, String description, double cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }
    /**
     * Returns the product's data in CSV format
     * @return the product's data in CSV format
     */
    public String toCSV() {
        return String.format("%s, %s, %s, %.2f", id, name, description, cost);
    }
    /**
     * Returns the product's data in JSON format
     * @return the product's data in JSON format
     */
    public String toJSON() {
        char DQ = '\u0022';
        return "{" + DQ + "id" + DQ + ":" + DQ + id + DQ + ", " +
                DQ + "name" + DQ + ":" + DQ + name + DQ + ", " +
                DQ + "description" + DQ + ":" + DQ + description + DQ + ", " +
                DQ + "cost" + DQ + ":" + String.format("%.2f", cost) + "}";
    }
    /**
     * Returns the product's data in XML format
     * @return the product's data in XML format
     */
    public String toXML() {
        return "<product>\n" +
                "  <id>" + id + "</id>\n" +
                "  <name>" + name + "</name>\n" +
                "  <description>" + description + "</description>\n" +
                "  <cost>" + cost + "</cost>\n" +
                "</product>";
    }
    /**
     * Returns the product's data as a line in a formatted table
     * @return the product's data as a line in a formatted table
     */
    public String formattedData() {
        return String.format("%-8s%-15s%-30s%4.2f", id, name, description, cost);
    }
}