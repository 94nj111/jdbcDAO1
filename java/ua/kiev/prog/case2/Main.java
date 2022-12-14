package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection())
        {
            // remove this
            try {
                try (Statement st = conn.createStatement()) {
                    st.execute("DROP TABLE IF EXISTS Clients");
                    //st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            ClientDAOImpl2 dao = new ClientDAOImpl2(conn, "Clients");
            dao.createTable(Client.class);

            Client c = new Client("test", 1, new java.sql.Date(new Date().getTime()), 2.15);
            dao.add(c);
            Client c1 = new Client("test1", 12, new java.sql.Date(new Date().getTime()), 3.14);
            dao.add(c1);
            int id = c.getId();
            int id1 = c1.getId();

            System.out.println(id);
            System.out.println(id1);

            List<Client> list = dao.getAll(Client.class);
            for (Client cli : list)
                System.out.println(cli);

            list.get(0).setAge(55);
            dao.update(list.get(0));



//            List<Client> list = dao.getAll(Client.class, "name", "age");
            List<Client> list1 = dao.getAll(Client.class, "age");
            for (Client cli : list1)
                System.out.println(cli);



            dao.delete(list1.get(0));
        }
    }
}
