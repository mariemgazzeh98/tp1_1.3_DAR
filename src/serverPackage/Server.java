package serverPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Server {
	public static void main(String[] args) throws IOException {
		try {
			// Étape 1: Obtenir l'adresse IP réelle de la machine
			InetAddress adresseIP = InetAddress.getLocalHost();
			int port = 1234;
			
			// Créer le ServerSocket avec l'adresse IP et le port
			InetSocketAddress adresseSocket = new InetSocketAddress(adresseIP, port);
			ServerSocket serversocket = new ServerSocket();
			serversocket.bind(adresseSocket);
			
			// Afficher l'adresse IP du serveur
			System.out.println("Le serveur est demarre sur " + adresseIP.getHostAddress() + ":" + port);
			System.out.println("Je suis un serveur en attente la connexion d'un client");
			
			// Creation de l'objet Socket côté serveur suite à la connexion du client
			Socket socket = serversocket.accept();
			System.out.println("Un client est connecté : " + socket.getInetAddress().getHostAddress());
			
			InputStream is = socket.getInputStream();
			int x = is.read();
			int o = is.read();
			
			System.out.println("Valeur reçue x = " + x);
			System.out.println("Opération reçue = " + o);
			
			int res = 0;
			switch (o) {
				case 1:
					res = x + 5;
					System.out.println("Addition : " + x + " + 5 = " + res);
					break;
				case 2:
					res = x - 5;
					System.out.println("Soustraction : " + x + " - 5 = " + res);
					break;
				case 3:
					res = x * 5;
					System.out.println("Multiplication : " + x + " * 5 = " + res);
					break;
				case 4:
					res = x / 5;
					System.out.println("Division : " + x + " / 5 = " + res);
					break;
				default:
					System.out.println("Erreur : operateur invalide");
			}
			
			OutputStream os = socket.getOutputStream();
			os.write(res);
			
			// Fermeture de la Socket et la ServerSocket
			socket.close();
			serversocket.close();
			System.out.println("Client deconnecte");
			System.out.println("Serveur arrête");
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}