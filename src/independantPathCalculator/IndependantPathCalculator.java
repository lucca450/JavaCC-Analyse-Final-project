/**
 * 
 */
package independantPathCalculator;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Calcule le nombre de chemins d'ex�cution ind�pendants. Les chemins
 * d'ex�cutions doivent �tre dans le format suivant trace#trace#trace ... o�
 * trace est une cha�ne de caract�re unique � un segment de code ex�cut�.
 * 
 * @author Alexandre Ouellet {alexandre.ouellet@uqtr.ca}
 *
 */
public class IndependantPathCalculator {

	// Liste des chemins
	private String[] paths;

	/**
	 * Instancie un nouvel objet de calcul de chemins ind�pendants
	 * 
	 * @param paths les chemins d'ex�cution
	 */
	public IndependantPathCalculator(final String[] paths) {
		this.paths = paths;
	}

	/**
	 * Calcule le nombre de chemins de code ind�pendants dans les chemins fournit au
	 * constructeur.
	 * 
	 * @return le nombre de chemins d'ex�cutions ind�pendants d�crit par le path
	 */
	public int getIndependantPathsCount() {
		String[] pathSegments = findPathSegments().toArray(new String[0]);
		Z2Matrix pathMatrix = createPathMatrix(pathSegments);
		return pathMatrix.getRank();
	}

	/**
	 * �tablit la liste sans doublon de tous les segments de chemins.
	 * 
	 * @return la liste sans doublon des segments de chemin
	 */
	private HashSet<String> findPathSegments() {
		HashSet<String> pathSegments = new HashSet<String>();
		for (String path : paths) {
			String[] segments = path.split("#");

			for (String segment : segments) {
				pathSegments.add(segment);
			}
		}

		return pathSegments;
	}

	/**
	 * Cr�e une matrice repr�sentant les diff�rents chemins d'ex�cution. La liste
	 * des chemins possibles est fournie par la liste des �tiquettes. Chaque segment
	 * est une colonne de la matrice et chaque chemin une ligne. La valeur 0 est
	 * attribu�e si un chemin ne visite pas un segment et 1 si le segment est
	 * visit�.
	 * 
	 * @param segments la liste des segments de chemin possible.
	 * @return une matrice repr�sentant les chemins d'ex�cutions. Les colonnes sont
	 *         les segments de chemins et les lignes les chemins.
	 */
	private Z2Matrix createPathMatrix(String[] segments) {
		Z2Matrix matrix = new Z2Matrix(paths.length, segments.length);

		for (int i = 0; i < paths.length; i++) {
			String[] pathSeg = paths[i].split("#");
			Arrays.sort(pathSeg);
			
			for (int j = 0; j < segments.length; j++) {
				if(Arrays.binarySearch(pathSeg, segments[j]) >= 0) { // Cl� trouv�e
					matrix.setElement((byte) 1, i, j);
				}
			}
		}
		
		return matrix;
	}
}
