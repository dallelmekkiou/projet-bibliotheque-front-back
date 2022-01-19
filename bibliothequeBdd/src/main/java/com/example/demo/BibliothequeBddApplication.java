package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.example.demo.dao.BibliothequeRepository;
import com.example.demo.dao.LivreRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Bibliotheque;
import com.example.demo.entities.Livre;
import com.example.demo.entities.User;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class BibliothequeBddApplication implements CommandLineRunner{
	
	// l'injection de dependence 
		@Autowired
		private BibliothequeRepository bRepo;	
		@Autowired
		private UserRepository uRepo;	
		@Autowired
		private LivreRepository lRepo;		
		@Autowired
		RepositoryRestConfiguration rrc;
		
	public static void main(String[] args) {
		SpringApplication.run(BibliothequeBddApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		rrc.exposeIdsFor(Bibliotheque.class);
		rrc.exposeIdsFor(User.class);
		rrc.exposeIdsFor(Livre.class);
		/*
		 * uRepo.save(new User(null,"dallel","dd")); uRepo.save(new
		 * User(null,"mohamed","mm")); uRepo.save(new User(null,"salah","ss"));
		 * 
		 * bRepo.save(new Bibliotheque(null,"Bibliothèque d’Ursino, Catane, Italie"
		 * ,"La bibliothèque se situe dans le Château d’Ursino, une forteresse du XIIIe siècle située à Catane, en Sicile."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/1-Bibliotheque-Ursino-Catane-Italie.jpg","Via Biblioteca, 13, 95124 Catania CT, Italie"
		 * ,"+39 095 316883",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque Royale, Madrid, Espagne"
		 * ,"Située dans le Palais Royal de Madrid, la bibliothèque contient 300 000 œuvres imprimées, 4 000 manuscrits, 3 000 œuvres musicales et 2 000 gravures et dessins, repartis dans 24 salles."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/2-Bibliotheque-Royale-madrid-Espagne.jpg","P.º de Recoletos, 20-22, 28001 Madrid, Espagne"
		 * ,"+34 915 80 78 00",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque de l’Abbaye de Melk, Autriche"
		 * ,"La fresque du plafond, peinte par Paul Troger (1731-32), représente une allégorie de la Foi. La bibliothèque renferme environ 85 000 volumes et 1 200 manuscrits ."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/3-Bibliotheque-Abbaye-Melk-Melk-Autriche.jpg","Abt-Berthold-Dietmayr-Straße 1, 3390 Melk, Autriche"
		 * ,"+43 2752 5550",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque de l’Assemblée Nationale, Paris, France"
		 * ,"Elle est située à Paris au palais Bourbon et sa collection provient principalement des biens confisqués aux aristocrates au cours de la Révolution. La bibliothèque a été décorée au XIXe siècle par Eugène Delacroix."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/4-Bibliotheque-Assemblee-Nationale-Paris-France.jpg","126 rue de l'Université, 75355, Paris 07"
		 * ,"+33 140 63 60 00",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque universitaire de Copenhague, Danemark"
		 * ,"Fondée en 1482, elle est la plus ancienne bibliothèque du Danemark."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/5-Bibliotheque-universite-Copenhague-Danemark.jpg","Nørre Allé 49, 2200 København, Danemark"
		 * ,"+45 33 47 47 47",null)); bRepo.save(new Bibliotheque(
		 * null,"Bibliothèque de l’université de Humboldt, Berlin, Allemagne"
		 * ,"Fondée en 1831, la bibliothèque de l’université Humboldt est la plus ancienne bibliothèque de Berlin."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/6-Bibliotheque-universite-Humboldt-Berlin-Allemagne.jpg","Geschwister-Scholl-Straße 1-3, 10117 Berlin, Allemagne"
		 * ,"+49 30 209399370",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque de Pannonhalma, Hongrie"
		 * ,"La bibliothèque appartient à l’Abbaye du même nom. Fondée au 10e siècle, elle accueille 45 moines."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/7-Bibliotheque-Pannonhalma-Hongrie.jpg","Pannonhalma, Petőfi u. 25/a, 9090 Hongrie"
		 * ,"+36 96 554 050",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque d’État du Victoria, Melbourne, Australie"
		 * ,"La bibliothèque est célèbre pour sa salle de lecture à dôme. Elle mesure 34,75 m en diamètre comme en hauteur, et son oculus fait près de 5 m de large. Lors de son achèvement, ce dôme était le plus grand de ce type au monde."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/8-Bibliotheque-Victoria-Melbourne-Australie.jpg","328 Swanston St, Melbourne VIC 3000, Australie"
		 * ,"+61 3 8664 7000",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque du Musée Condé, Chantilly, France"
		 * ,"La bibliothèque est aménagée entre 1876 et 1877 par l’architecte du château Honoré Daumet et contient les 30 000 ouvrages du XIXe siècle et les documents bibliographiques qui servaient d’outils de travail au duc d’Aumale."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/9-Bibliotheque-du-Chateau-de-Chantilly-France.jpg","Route Pavée, 60500 Chantilly"
		 * ,"+33 344 27 31 80",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque du Congrès, Washington, États-Unis"
		 * ,"La bibliothèque nationale américaine, instituée en 1800, est la bibliothèque fédérale la plus ancienne du pays."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/10-Bibliotheque-Congres-Washingtonetats-Unis.jpg","101 Independence Ave SE, Washington, DC 20540, États-Unis"
		 * ,"+1 202-707-5000",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque du Palais National de Mafra, Portugal"
		 * ,"La bibliothèque en style rocaille est, avec ses 83 mètres de longueur, la salle la plus grande du Palais. C’est la plus importante bibliothèque monastico-royale du XVIIIe siècle, existante au Portugal."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/11-Bibliotheque-Palais-National-Mafra-Mafra-Portugal.jpg","Terreiro D. João V, Mafra, Portugal"
		 * ,"+351 261 817 550",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque John Rylands, Manchester, Royaume-Uni"
		 * ,"La John Rylands Library est installée dans un bâtiment néo-gothique en grès de Cumbria, évoquant une église. Elle est un bâtiment classé depuis 1952."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/12-Bibliotheque-John-Rylands-Manchester-Royaume-Uni.jpg","Manchester,150 Deansgate, Manchester M3 3EH, Royaume-Uni"
		 * ,"+44 161 306 0555",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque municipale de Stuttgart, Allemagne"
		 * ,"Haute de 40 m, ce cube est l’oeuvre de l’architecte coréen Eun Young Yi."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/13-Bibliotheque-municipale-Stuttgart-Allemagne.jpg","Mailänder Platz 1, 70173 Stuttgart, Allemagne"
		 * ,"+49 711 21691100",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque municipale, Bologne, Italie"
		 * ,"Cette bibliothèque, ancienne salle du commerce de Bologne, a été restaurée récemment et offre un plancher de verre qui permet d’observer les ruines romaines en contrebas."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/14-Bibliotheque-municipale-Bologne-Italie.jpg","Piazza Galvani, 1, 40124 Bologna BO, Italie"
		 * ," +39 051 276811",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque publique, Boston, États-Unis"
		 * ,"Fondée en 1848, elle héberge 14,9 millions de livres, 600 000 photographies, des dessins de Rembrandt, Goya, Toulouse-Lautrec et 350 000 cartes anciennes. Elle abrite aussi un million de manuscrits."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/15-Bibliotheque-municipale-Boston-etats-Unis.jpg","700 Boylston St, Boston, MA 02116, États-Unis"
		 * ,"+1 617-536-5400",null)); bRepo.save(new
		 * Bibliotheque(null,"Bibliothèque publique, New York, États-Unis"
		 * ,"Avec près de 53 millions de documents, la New York Public Library est la seconde plus grande bibliothèque publique des États-Unis, derrière la Bibliothèque du Congrès."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/16-Bibliotheque-municipale-New-York-etats-Unis.jpg","476 5th Ave, New York, NY 10018, États-Unis"
		 * ,"+1 917-275-6975",null)); bRepo.save(new
		 * Bibliotheque(null,"Cabinet Royal Portugais, Rio de Janeiro, Brésil"
		 * ,"Le Cabinet Royal, de style néo-manuélin, est l’oeuvre de l’architecte portugais Rafael Da Silva e Castro, et a été construit à la fin du XIXe siècle. Il a été classé 2e plus belle bibliothèque au monde par le site BuzzFeed"
		 * ,"https://viago.ca/wp-content/uploads/2017/09/17-Cabinet-Royal-Rio-de-Janeiro-Bresil.jpg","R. Luís de Camões, 30 - Centro, Rio de Janeiro - RJ, 20051-020, Brésil"
		 * ,"+55 21 2221-3138",null)); bRepo.save(new
		 * Bibliotheque(null,"El Ateneo, Buenos Aires, Argentine"
		 * ,"Il s’agit en fait plus d’une librairie que d’une bibliothèque, mais avec son cadre et rayonnages impressionnants, El Ateneo figure dans notre classement. De 1919 à 2000, El Ateneo fut, tour à tour, théâtre, radio et cinéma."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/18-El-Ateneo-Buenos-Aires-Argentine.jpg","Av. Santa Fe 1860, C1123 CABA, Argentine"
		 * ,"+54 11 4813-6052",null)); bRepo.save(new
		 * Bibliotheque(null,"Monastère de Strahov, Prague, République tchèque"
		 * ,"Cette bibliothèque, vieille de plus de huit cents ans, reste une des plus importantes de Bohême. La salle théologique, ornée de fresques exaltant l’amour du savoir, abrite des globes astronomiques réalisés au XVIIe siècle par William Blaeu."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/19-Monastere-de-Strahov-Prague-Rep-Tcheque.jpg","Strahovské nádvoří 1/132, 118 00 Praha 1-Strahov, Tchéquie"
		 * ,"+420 233 107 704",null)); bRepo.save(new
		 * Bibliotheque(null,"Trinity College Library, Dublin, Irlande"
		 * ,"Il s’agit de la plus ancienne bibliothèque de Dublin et la plus grande d’Irlande. Dans la «long room», près de 3 millions d’ouvrages sont conservés."
		 * ,"https://viago.ca/wp-content/uploads/2017/09/20-Trinity-College-Library-Dublin-Irlande.jpg"," Old Library, College Green, South-East Inner City, Dublin 2, D02 VR66, Irlande"
		 * ,"+353 1 896 1000",null));
		 * 
		 * lRepo.save(new Livre(null,"t","t",null));
		 * 
		 */
		/*
		 * bRepo.findAll().forEach(b->{ System.out.println("id :"+b.getId());
		 * System.out.println("nom :"+b.getNom());
		 * System.out.println("description :"+b.getDescription());
		 * System.out.println("image :"+b.getImage());
		 * System.out.println("adresse :"+b.getAdresse());
		 * System.out.println("tel :"+b.getTel());
		 * System.out.println("livres :"+b.getLivres()); });
		 * 
		 * uRepo.findAll().forEach(u->{ System.out.println("id :"+u.getId());
		 * System.out.println("username :"+u.getUsername());
		 * System.out.println("password :"+u.getPassword()); });
		 * 
		 * lRepo.findAll().forEach(l->{ System.out.println("id :"+l.getId());
		 * System.out.println("titre :"+l.getTitre());
		 * System.out.println("description :"+l.getDescription()); });
		 */
		/*
		 * Bibliotheque b =new Bibliotheque(null, "", "", "", "", "", null);
		 * Bibliotheque b1 =new Bibliotheque(null, "", "", "", "", "", null);
		 * Bibliotheque b2 =new Bibliotheque(null, "", "", "", "", "", null);
		 * Bibliotheque b3 =new Bibliotheque(null, "", "", "", "", "", null);
		 */

		/*
		 * Livre l1= lRepo.save(new Livre(null,"t","t",null)); Livre l2= lRepo.save(new
		 * Livre(null,"p","p",null)); Livre l3= lRepo.save(new
		 * Livre(null,"m","m",null)); Livre l4= lRepo.save(new
		 * Livre(null,"m","m",null)); Livre l5= lRepo.save(new
		 * Livre(null,"m","m",null)); Collection<Livre> livres; livres=new
		 * ArrayList<Livre>(); livres.add(l1); livres.add(l2); livres.add(l3);
		 * livres.add(l4); livres.add(l5); bRepo.findAll().forEach(b->{
		 * System.out.println(b); b.setLivres(livres); bRepo.save(b); });
		 */
		  Random random = new Random(); bRepo.findAll().forEach(b->{
		  b.setNbrAdherent(random.nextInt(100));
		  });
		 		
}
}
