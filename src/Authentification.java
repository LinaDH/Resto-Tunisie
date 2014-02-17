
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;

class Authentification  {

//Objet pour se connecter à la base de données
public Base bd = new Base();
public Connection conn;
static JTextField Login, MotDePasse;
    
//Objet PreparedStatement
    PreparedStatement statement = null;
    //Objet ResultSet
    ResultSet resultat = null;

public Authentification() {

}

public void actionPerformed(ActionEvent ae)
{

  String login = Login.getText();
  String password = MotDePasse.getText();
  bd.ConnexionBD();
  conn = bd.getConnect();

//Manipulation
try {
//Création de la requête
statement conn.prepareStatement("SELECT password FROM utilisateurs WHERE login'"+login+"'");

resultat = statement.executeQuery();

if(resultat.next())
{
String motDePasse = resultat.getString(1);
if(motDePasse.equals(password))
{
JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
}
else {
JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
}
}
else {
JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
}

//Récupération de la requête dans une variable
resultat = statement.executeQuery();

conn.close();
}
catch (SQLException e) {
System.out.println(e.getMessage());
}
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}