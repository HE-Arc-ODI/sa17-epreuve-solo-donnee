package ch.hearc.ig.odi.service;

import ch.hearc.ig.odi.business.Player;
import ch.hearc.ig.odi.business.Question;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Mock persistence service class. Used as singleton to simulate persistence
 */
public class MockPersistence {

  public static final String CSV_FILE_PATH = "../csv/openquizzdb_fr.csv";
  private Map<Long, Question> questions;
  private List<Player> players;
  private int playerCount = 0;


  /**
   * Empty constructor. All initialization should be done here.
   */
  public MockPersistence() {
    this.questions = new HashMap();
    this.players = new ArrayList();

    this.players.add(new Player("Alice", Long.valueOf(playerCount++)));
    this.players.add(new Player("Bob", Long.valueOf(playerCount++)));
    this.players.add(new Player("Claude",  Long.valueOf(playerCount++)));

    Reader csvReader = null;

    try {
      csvReader = new InputStreamReader(getClass().getResourceAsStream(CSV_FILE_PATH), "UTF-8");

      // Définition des règles de parsing pour que le fichier soit lu correctement
      CSVFormat format = CSVFormat.DEFAULT;
      format = format.withQuote('"');
      format = format.withDelimiter(';');
      format = format.withFirstRecordAsHeader();

      Iterable<CSVRecord> records = null;
      records = format.parse(csvReader);

      // Boucle sur chaque ligne du fichier CSV et crée un objet Question correspondant
      for (CSVRecord record : records) {
        Long currentId = new Long(record.get("id"));

        questions.put(currentId, new Question(
            currentId,
            record.get("category"),
            record.get("question"),
            record.get("correct_answer"),
            record.get("wrong_answer1"),
            record.get("wrong_answer2"),
            record.get("wrong_answer3"),
            record.get("link")));
      }

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Retourne l'objet Question correspondant à l'ID reçu en paramètre, ou null si aucune question ne
   * correspond
   *
   * @param id ID de la question recherchée
   * @return Un objet Question, ou null si aucune correspondance n'est trouvée
   */
  public Question getQuestionWithId(Long id) {
    return questions.get(id);
  }

  /**
   * Retourne une List contenant toutes les questions
   *
   * @return La List contenant toutes les questions
   */
  public List<Question> getQuestions() {

    List l = new ArrayList<Question>();

    Iterator i = this.questions.keySet().iterator();
    while (i.hasNext()) {
      l.add(this.questions.get((Long) i.next()));
    }
    return l;
  }

  /**
   * Retourne la liste de tous les joureurs de l'application
   *
   * @return La liste contenant tous les joueurs
   */
  public List<Player> getPlayers() {
    return this.players;
  }


  /**
   * Recherche un joueur par son alias
   *
   * @param alias Le joueur à rechercher
   * @return Retoure un Player s'il est trouvé dans la liste, sinon retourne null
   */
  public Player findPlayerByAlias(String alias) {
    for (Player p : this.players) {
      if (p.getAlias().equals(alias)) {
        return p;
      }
    }
    return null;
  }

  /**
   * Ajoute un joueur à la liste des joueurs.
   *
   * @param player Le joueur a ajouter
   */
  public void addPlayer(Player player) {
    this.players.add(player);
  }

  /**
   * Retourne le nommbre de joueur dans le classement final
   *
   * @return Retourne la taille de liste contenant les joueur
   */
  public int getNbPlayers() {
    return this.players.size();
  }


  public List<Question> getTenRandomQuestions() {
    return getRandomQuestions(10);
  }

  public List<Question> getRandomQuestions(int number) {
    ArrayList<Question> shuffledQuestions = new ArrayList<Question>(questions.values());
    Collections.shuffle(shuffledQuestions);
    return shuffledQuestions.subList(0, number);
  }
}
