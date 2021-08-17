
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 *  Une piece dans un jeu d'aventure. <p>
 *
 *  Cette classe fait partie du logiciel Zork, un jeu d'aventure simple en mode
 *  texte.</p>
 *
 *  <p>Une "Piece" represente un des lieux dans lesquels se déroule l'action du
 *  jeu. Elle est reliée a au plus quatre autres "Piece" par des sorties. Les
 *  sorties sont étiquettées "nord", "est", "sud", "ouest". Pour chaque
 *  direction, la "Piece" possède une référence sur la piece voisine ou null
 *  s'il n'y a pas de sortie dans cette direction.</p>
 *
 *  <p>Une Piece est aussi un conteneur d'ObjetZork possédant les propriétés
 *  suivantes:
 * <ul>
 *  <li>Un nombre non borné d'ObjetZork peut être ajouté dans la Piece.</li>
 *  <li>La Piece peut contenir plusieurs exemplaires d'un même ObjetZork</li>
 *  <li>La valeur null n'est pas autorisée parmi les ObjetZork présents dans
 *  la Piece</li>
 *  <li>Les objets contenus dans la Piece ne sont pas ordonnés</li>
 *  <li>La méthode equals de ObjetZork est utilisée pour toutes les opérations
 *  nécessitant de tester la présence d'un ObjetZork</li>
 * </ul>
 * </p>
 *
 * @invariant !contient(null);
 * @invariant descriptionCourte() != null;
 * @invariant descriptionLongue() != null;
 * @invariant descriptionSorties() != null;
 * @invariant getNbObjets() >= 0;
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @since      August 2000
 * @version    23 mai 2009
 */

public class Piece extends ArrayListConteneur {
    private String description;

    // mémorise les sorties de cette piece.
    private HashMap<String, Piece> sorties;

    /**
     *  Initialise une piece décrite par la chaine de caractères spécifiée.
     *  Initialement, cette piece ne possède aucune sortie. La description fournie
     *  est une courte phrase comme "la bibliothèque" ou "la salle de TP".
     *
     * @requires description != null;
     * @ensures descriptionCourte() == description;
     * @ensures getNbObjets() == 0;
     * @ensures pieceSuivante("nord") == null;
     * @ensures pieceSuivante("est") == null;
     * @ensures pieceSuivante("sud") == null;
     * @ensures pieceSuivante("ouest") == null;
     *
     * @param  description  Description de la piece.
     * @throws NullPointerException si le paramètre est null
     */
    public Piece(String description) {
    	if (description == null) {
    		throw new NullPointerException("La description d'une Piece ne peut-être null");
    	}
        this.description = description;
        sorties = new HashMap<String, Piece>(4);

        //lesObjets = new ObjetZork[5];
    }

    /**
     *  Initialise une piece décrite par la chaine de caractères spécifiée et
     *  contenant les nbObjets premiers objets contenu dans le tableau spécifié. Le
     *  tableau spécifié doit etre non <code>null</code> et contenir au moins
     *  nbObjets (i.e. les nbObjets premiers éléments du tableau doivent être
     *  des instances non <code>null</code> de la classe ObjetZork. Initialement,
     *  cette piece ne possède aucune sortie. La description fournie est une courte
     *  phrase comme "la bibliothèque" ou "la salle de TP".
     *
     * @requires description != null;
     * @ensures pieceSuivante("nord") == null;
     * @ensures pieceSuivante("est") == null;
     * @ensures pieceSuivante("sud") == null;
     * @ensures pieceSuivante("ouest") == null;
     *
     * @param  description  Description de la piece.;
     * @throws NullPointerException si l'un des paramètres est null ;
     */
    public Piece(String description, Conteneur tabObjets) {

        super(tabObjets);
        if(description==null){
          throw new NullPointerException("la piece doit obligatoirement avoir une description");
        }
        this.description=description;

    }


    /**
     *  Définie les sorties de cette piece. A chaque direction correspond ou bien
     *  une piece ou bien la valeur null signifiant qu'il n'y a pas de sortie dans
     *  cette direction.
     *
     * @ensures (nord != null) ==> (pieceSuivante("nord") == nord);
     * @ensures (est != null) ==> (pieceSuivante("est") == est);
     * @ensures (sud != null) ==> (pieceSuivante("sud") == sud);
     * @ensures (ouest != null) ==> (pieceSuivante("ouest") == ouest);
     * @ensures (nord == null) ==> (pieceSuivante("nord") == \old(pieceSuivante("nord")));
     * @ensures (est == null) ==> (pieceSuivante("est") == \old(pieceSuivante("est")));
     * @ensures (sud == null) ==> (pieceSuivante("sud") == \old(pieceSuivante("sud")));
     * @ensures (ouest == null) ==> (pieceSuivante("ouest") == \old(pieceSuivante("ouest")));
     *
     *
     * @param  nord   La sortie nord
     * @param  est    La sortie est
     * @param  sud    La sortie sud
     * @param  ouest  La sortie ouest
     */
    public void setSorties(Piece nord, Piece est, Piece sud, Piece ouest) {
        if (nord != null) {
            sorties.put("nord", nord);
        }
        if (est != null) {
            sorties.put("est", est);
        }
        if (sud != null) {
            sorties.put("sud", sud);
        }
        if (ouest != null) {
            sorties.put("ouest", ouest);
        }
    }

    /**
     *  Renvoie la piece atteinte lorsque l'on se déplace a partir de cette piece
     *  dans la direction spécifiée. Si cette piece ne possède aucune sortie dans
     *  cette direction, renvoie null.
     *
     * @ensures (!direction.equals("nord")
     *			&& !direction.equals("est")
     *			&& !direction.equals("sud")
     *			&& !direction.equals("ouest")) ==> (\result == null);
     *
     * @param  direction  La direction dans laquelle on souhaite se déplacer
     * @return            Piece atteinte lorsque l'on se déplace dans la direction
     *      spécifiée ou null.
     *
     * @pure
     */
    public Piece pieceSuivante(String direction) {
        return sorties.get(direction);
    }

    /**
     *  Renvoie la description de cette piece (i.e. la description spécifiée lors
     *  de la création de cette instance).
     *
     * @return    Description de cette piece
     *
     * @pure
     */
    public String descriptionCourte() {
        return description;
    }


    /**
     *  Renvoie une description de cette piece mentionant ses sorties et
     *  directement formatée pour affichage, de la forme: <pre>
     *  Vous etes dans la bibliothèque.
     *  Sorties: nord ouest</pre> Cette description utilise la chaine de caractères
     *  renvoyée par la méthode descriptionSorties pour décrire les sorties de
     *  cette piece.
     *
     * @return    Description affichable de cette piece.
     *
     * @pure
     */
    public String descriptionLongue() {
        return "Vous etes dans " + description + ".\n" + descriptionSorties();
    }


    /**
     *  Renvoie une description des sorties de cette piece, de la forme: <pre>
     *  Sorties: nord ouest</pre> Cette description est utilisée dans la
     *  description longue d'une piece.
     *
     * @return    Une description des sorties de cette pièce.
     *
     * @pure
     */
    public String descriptionSorties() {
        String resulString = "Sorties:";
        Set<String> keys = sorties.keySet();
        for (Iterator<String> iter = keys.iterator(); iter.hasNext(); ) {
            resulString += " " + iter.next();
        }
        return resulString;
    }
}
