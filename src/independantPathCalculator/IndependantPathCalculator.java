/**
 * 
 */
package independantPathCalculator;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Calcule le nombre de chemins d'exécution indépendants. Les chemins
 * d'exécutions doivent être dans le format suivant trace#trace#trace ... où
 * trace est une chaîne de caractère unique à un segment de code exécuté.
 * 
 * @author Alexandre Ouellet {alexandre.ouellet@uqtr.ca}
 *
 */
public class IndependantPathCalculator {

	// Liste des chemins
	private String[] paths;

	/**
	 * Instancie un nouvel objet de calcul de chemins indépendants
	 * 
	 * @param paths les chemins d'exécution
	 */
	public IndependantPathCalculator(final String[] paths) {
		this.paths = paths;
	}

	/**
	 * Calcule le nombre de chemins de code indépendants dans les chemins fournit au
	 * constructeur.
	 * 
	 * @return le nombre de chemins d'exécutions indépendants décrit par le path
	 */
	public int getIndependantPathsCount() {
		String[] pathSegments = findPathSegments().toArray(new String[0]);
		Z2Matrix pathMatrix = createPathMatrix(pathSegments);
		return pathMatrix.getRank();
	}

	/**
	 * Établit la liste sans doublon de tous les segments de chemins.
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
	 * Crée une matrice représentant les différents chemins d'exécution. La liste
	 * des chemins possibles est fournie par la liste des étiquettes. Chaque segment
	 * est une colonne de la matrice et chaque chemin une ligne. La valeur 0 est
	 * attribuée si un chemin ne visite pas un segment et 1 si le segment est
	 * visité.
	 * 
	 * @param segments la liste des segments de chemin possible.
	 * @return une matrice représentant les chemins d'exécutions. Les colonnes sont
	 *         les segments de chemins et les lignes les chemins.
	 */
	private Z2Matrix createPathMatrix(String[] segments) {
		Z2Matrix matrix = new Z2Matrix(paths.length, segments.length);

		for (int i = 0; i < paths.length; i++) {
			String[] pathSeg = paths[i].split("#");
			Arrays.sort(pathSeg);
			
			for (int j = 0; j < segments.length; j++) {
				if(Arrays.binarySearch(pathSeg, segments[j]) >= 0) { // Clé trouvée
					matrix.setElement((byte) 1, i, j);
				}
			}
		}
		
		return matrix;
	}
}
