import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieInfoPage extends JDialog {
    private JPanel movieInfoPanel;
    private JPanel buttonPanel;
    private JButton backToMovieSelectionButton;
    private JButton reserveTicketsButton;
    private JLabel col1LB;
    private JLabel movieImage;
    private JLabel col2LB;
    private JLabel col3LB;
    private JLabel col4LB;
    private JLabel col5LB;
    public User user;




    public MovieInfoPage(JFrame parent, int movieID)
    {
        //when button is pressed set visible
        //display info on window
        //user clicks back or continue to reservation page
        super(parent);

        setTitle("Movie Information");
        setContentPane(movieInfoPanel);
        setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backToMovieSelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show selectionPage form
            }
        });
        reserveTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show reservationPage form
            }
        });

        showMovieInfo(movieID);

        setVisible(true);

    }

    private void showMovieInfo(int movie)
    {
        //System.out.println("Entering ShowMovieInfo()");
        ImageIcon image1 = new ImageIcon("src/movie1.jpeg");
        ImageIcon image2 = new ImageIcon("/movie2.jpeg");
        ImageIcon image3 = new ImageIcon("/movie3.jpeg");
        ImageIcon image4 = new ImageIcon("movie4.jpeg");
        ImageIcon image5 = new ImageIcon("movie5.jpeg");
        ImageIcon image6 = new ImageIcon("movie6.jpeg");
        ImageIcon image7 = new ImageIcon("movie7.jpeg");
        ImageIcon image8 = new ImageIcon("movie8.jpeg");
        ImageIcon image9 = new ImageIcon("movie9.jpeg");

        final String DB_URL = "jdbc:mysql://localhost/moviebookingsystemdb";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql;

            ResultSet resultSet;


            if(movie == 1)
            {
                System.out.println("movie == 1");
                sql = "SELECT * from moviecollection WHERE ID=1";

                resultSet = stmt.executeQuery(sql);


                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }

                movieImage.setIcon(image1);

            }
            if(movie == 2)
            {
                System.out.println("movie == 2");
                sql = "SELECT * from moviecollection WHERE ID=2";

                resultSet = stmt.executeQuery(sql);

                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }

                movieImage.setIcon(image2);
            }
            if(movie == 3)
            {
                System.out.println("movie == 3");
                sql = "SELECT * from moviecollection WHERE ID=3";

                resultSet = stmt.executeQuery(sql);

                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }
                movieImage.setIcon(image3);
            }
            if(movie == 4)
            {
                System.out.println("movie == 4");
                sql = "SELECT * from moviecollection WHERE ID=4";

                resultSet = stmt.executeQuery(sql);
                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }
                movieImage.setIcon(image4);
            }
            if(movie == 5)
            {
                System.out.println("movie == 5");
                sql = "SELECT * from moviecollection WHERE ID=5";

                resultSet = stmt.executeQuery(sql);
                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }
                movieImage.setIcon(image5);
            }
            if(movie == 6)
            {
                System.out.println("movie == 6");
                sql = "SELECT * from moviecollection WHERE ID=6";

                resultSet = stmt.executeQuery(sql);
                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }
            }
            if(movie == 7)
            {
                System.out.println("movie == 7");
                sql = "SELECT * from moviecollection WHERE ID=7";

                resultSet = stmt.executeQuery(sql);
                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }
            }
            if(movie == 8)
            {
                System.out.println("movie == 8");
                sql = "SELECT * from moviecollection WHERE ID=8";

                resultSet = stmt.executeQuery(sql);
                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }
            }
            if(movie == 9)
            {
                System.out.println("movie == 9");
                sql = "SELECT * from moviecollection WHERE ID=9";

                resultSet = stmt.executeQuery(sql);
                if(resultSet.next())
                {
                    col1LB.setText(resultSet.getString(1));
                    col2LB.setText(resultSet.getString(2));
                    col3LB.setText(resultSet.getString(3));
                    col4LB.setText(resultSet.getString(4));
                    col5LB.setText(resultSet.getString(5));
                }

            }

            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }



    public static void main(String[] args) {
        MovieInfoPage movieInfoPage = new MovieInfoPage(null,0);
        User user = movieInfoPage.user;

        if(user != null)
        {
            System.out.println("Movie Info Displayed");
        }
        else
        {
            System.out.println("Need to login or signup");
        }
    }
}
