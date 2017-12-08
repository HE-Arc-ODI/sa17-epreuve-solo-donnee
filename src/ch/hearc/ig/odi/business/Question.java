package ch.hearc.ig.odi.business;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Question implements Serializable{

    /**
     * L'ID unique de la question
     */
    private Long id;

    /**
     * La catégorie liée à la question
     */
    private String category;

    /**
     * Le texte de la question
     */
    private String question;

    /**
     * Les 4 réponses possibles pour la question
     * On utilise un Set car cela va "mélanger" les réponses
     */
    private Set<String> answers;

    /**
     * La réponse correcte à la question
     */
    private String correctAnswer;

    /**
     * Un lien Wikipedia pour avoir plus d'informations sur la réponse à la question
     */
    private String link;

    /**
     * Initialise "answers"
     */
    public Question() {
        this.answers = new HashSet();
    }

    /**
     * Construit un objet "Question" avec tous ses attributs
     * La réponse correcte et les trois mauvaises réponses sont toutes placées dans le Set "answers"
     * @param id L'ID de la question
     * @param category La catégorie
     * @param question Le texte de la question
     * @param correctAnswer La réponse correcte
     * @param wrongAnswer1 La 1ère mauvaise réponse
     * @param wrongAnswer2 La 2ème mauvaise réponse
     * @param wrongAnswer3 La 3ème mauvaise réponse
     * @param link Le lien wikipedia pour avoir plus d'informations sur la bonne réponse
     */
    public Question(Long id, String category, String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String link) {
        this();

        this.id = id;
        this.category = category;
        this.question = question;
        this.correctAnswer = correctAnswer;

        answers.add(correctAnswer);
        answers.add(wrongAnswer1);
        answers.add(wrongAnswer2);
        answers.add(wrongAnswer3);

        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Set<String> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<String> answers) {
        this.answers = answers;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
