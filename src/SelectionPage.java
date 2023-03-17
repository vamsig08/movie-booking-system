import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SelectionPage extends JFrame {
    private JPanel selectionPanel;
    private JButton movie1;
    private JButton movie2;
    private JButton movie3;
    private JButton movie4;
    private JButton movie5;
    private JButton movie6;
    private JButton movie7;
    private JButton movie8;
    private JButton movie9;
    public User user;

    public SelectionPage(JFrame parent)
    {

        setTitle("Select");
        setContentPane(selectionPanel);
        setMinimumSize(new Dimension(900, 600));

        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        movie1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(1);
                //create movieinfopage(1) obj
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,1);
                user = movieInfoPage.user;
            }
        });
        movie2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(2);
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,2);
                user = movieInfoPage.user;
            }
        });
        movie3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(3);
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,3);
                user = movieInfoPage.user;
            }
        });
        movie4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(4);
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,4);
                user = movieInfoPage.user;
            }
        });
        movie5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(5);
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,5);
                user = movieInfoPage.user;
            }
        });
        movie6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(6);
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,6);
                user = movieInfoPage.user;
            }
        });
        movie7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(7);
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,7);
                user = movieInfoPage.user;
            }
        });
        movie8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(8);
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,8);
                user = movieInfoPage.user;
            }
        });
        movie9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showMovieInfo(9);
                MovieInfoPage movieInfoPage = new MovieInfoPage(SelectionPage.this,9);
                user = movieInfoPage.user;
            }
        });
        setVisible(true);

    }

    /*
    private void showMovieInfo(int movie)
    {
        //System.out.println("Entering ShowMovieInfo()");

        final String DB_URL = "jdbc:mysql://localhost/moviebookingsystemdb";
        final String USERNAME = "root";
        final String PASSWORD = "";
        String col1 = null, col2 = null, col3 = null, col4 = null, col5 = null;
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql;
            String[] columns = {col1, col2, col3, col4, col5};

            ResultSet resultSet;


            if(movie == 1)
            {
                System.out.println("movie == 1");
                sql = "SELECT * from moviecollection WHERE ID=1";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);

                    if(resultSet.next())
                    {
                        col1 = resultSet.getString(1);
                        col2 = resultSet.getString(2);
                        col3 = resultSet.getString(3);
                        col4 = resultSet.getString(4);
                        col5 = resultSet.getString(5);
                    }
                    printMovieInfo(columns);
            }
            if(movie == 2)
            {
                System.out.println("movie == 2");
                sql = "SELECT * from moviecollection WHERE ID=2";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);
            }
            if(movie == 3)
            {
                System.out.println("movie == 3");
                sql = "SELECT * from moviecollection WHERE ID=3";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);
            }
            if(movie == 4)
            {
                System.out.println("movie == 4");
                sql = "SELECT * from moviecollection WHERE ID=4";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);
            }
            if(movie == 5)
            {
                System.out.println("movie == 5");
                sql = "SELECT * from moviecollection WHERE ID=5";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);
            }
            if(movie == 6)
            {
                System.out.println("movie == 6");
                sql = "SELECT * from moviecollection WHERE ID=6";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);
            }
            if(movie == 7)
            {
                System.out.println("movie == 7");
                sql = "SELECT * from moviecollection WHERE ID=7";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);
            }
            if(movie == 8)
            {
                System.out.println("movie == 8");
                sql = "SELECT * from moviecollection WHERE ID=8";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);
            }
            if(movie == 9)
            {
                System.out.println("movie == 9");
                sql = "SELECT * from moviecollection WHERE ID=9";

                resultSet = stmt.executeQuery(sql);
                createMovieInfoWindow(resultSet);
            }

            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void createMovieInfoWindow(ResultSet movieSet)
    {
        //create new frame to display movie picture and image
    }

    private void printMovieInfo(String[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
    */
    //connect to db to view movies
    //each movie button will display corresponding movie info from db

    public static void main(String[] args) {
        SelectionPage selectionPage = new SelectionPage(null);
        User user = selectionPage.user;
    }
}
