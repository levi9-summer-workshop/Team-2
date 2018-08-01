//package rs.levi9.survey.domain;
//
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "answers")
//public class Answer extends BaseEntity {
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private SurveyUser user;
//
//    @OneToOne
//    @JoinColumn(name = "question_id")
//    private Question question;
//
//    @OneToOne
//    @JoinColumn(name = "choice_id")
//    private Choice choice;
//
//    @OneToOne
//    @JoinColumn(name = "survey_id")
//    private Survey survey;
//
//    public Answer() {}
//
//    public Answer(SurveyUser user, Question question, Choice choice, Survey survey) {
//        this.user = user;
//        this.question = question;
//        this.choice = choice;
//        this.survey = survey;
//    }
//
//    public SurveyUser getUser() {
//        return user;
//    }
//
//    public void setUser(SurveyUser user) {
//        this.user = user;
//    }
//
//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }
//
//    public Choice getChoice() {
//        return choice;
//    }
//
//    public void setChoice(Choice choice) {
//        this.choice = choice;
//    }
//
//    public Survey getSurvey() {
//        return survey;
//    }
//
//    public void setSurvey(Survey survey) {
//        this.survey = survey;
//    }
//}
