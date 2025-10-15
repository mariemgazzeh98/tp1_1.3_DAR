package clientPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.net.Socket;

import java.net.InetSocketAddress;

public class Client {
	public static void main(String[] args) {
		try {
			// Creation de l'objet Socket côté client
			System.out.println("Je suis un client pas encore connecte…");
			
			// Demander l'adresse IP du serveur
			Scanner sc = new Scanner(System.in);
			System.out.print("Entrez l'adresse IP du serveur (ou appuyez sur Entrée pour localhost) : ");
			String adresseServeur = sc.nextLine();
			
			// Si l'utilisateur appuie sur Entrée, utiliser localhost par défaut
			if (adresseServeur.trim().isEmpty()) {
				adresseServeur = "localhost";
			}
			
			int port = 1234;
			
			System.out.println("Connexion au serveur " + adresseServeur + ":" + port + "...");
			
			// Créer la socket avec l'adresse IP du serveur
			InetSocketAddress adresseSocket = new InetSocketAddress(adresseServeur, port);
			Socket socket = new Socket();
			socket.connect(adresseSocket, 5000); // Timeout de 5 secondes
			
			System.out.println("Je suis connecté au serveur " + socket.getInetAddress().getHostAddress());
			
			// Saisie l'entier x
			OutputStream os = socket.getOutputStream();
			System.out.print("Donner x : ");
			int x = sc.nextInt();
			os.write(x);
			
			System.out.println("\nChoisissez une opération :");
			System.out.println("1. Addition (+5)");
			System.out.println("2. Soustraction (-5)");
			System.out.println("3. Multiplication (*5)");
			System.out.println("4. Division (/5)");
			System.out.print("Entrez votre choix (1-4) : ");
			int o = sc.nextInt();
			os.write(o);
			
			InputStream is = socket.getInputStream();
			int res = is.read();
			
			
			System.out.println("Le résultat = " + res);
			
			// Fermeture de la Socket
			socket.close();
			sc.close();
			
			System.out.println("Déconnexion du serveur.");
		
		} catch(IOException e) {
			System.err.println("Erreur de connexion : " + e.getMessage());
			System.err.println("Vérifiez que le serveur est démarré et accessible.");
			e.printStackTrace();
		}
	}
}