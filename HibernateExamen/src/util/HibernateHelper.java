package util;



import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import view.Interfaz;

import java.util.List;








import model.Question;
import model.Answer;

public class HibernateHelper {
	//Variables pregunta
	public int idPregunta;
	public String categoria, pregunta;
	//Variables respuesta
	public int idRespuesta;
	public String textoRespuesta1,textoRespuesta2,textoRespuesta3,textoRespuesta4;
	public boolean iscorrect1,iscorrect2,iscorrect3,iscorrect4;
	
	Interfaz inter;
	private SessionFactory sesion;

	public HibernateHelper() {
		sesion = SessionFactoryUtil.getSessionFactory();
	}

	public void addQuestion(int idQuestion, String text, String category) {
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Question question = new Question(idQuestion, text, category);
		session.save(question);
		tx.commit();
		session.close();
	}

	public void addAnswer(String text, Boolean isCorrect, Integer idQuestion) {
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Answer answer = new Answer(text, isCorrect, idQuestion);
		session.save(answer);
		tx.commit();
		session.close();
	}

	public void getIdPregunta(int id) {
		Session session = sesion.openSession();
		Question idPregunta = (Question) session.get(Question.class, id);
		if (idPregunta != null)
			// session.(idPregunta);
			session.close();

	}
	
	public void listQuestion(int idQuestion){
		 
	      Session session = sesion.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List question = session.createQuery("FROM Question  as a where a.idQuestion = '"+idQuestion+"'").list(); 
	         for (Iterator iterator = 
	        		 question.iterator(); iterator.hasNext();){
	            Question questionIte = (Question) iterator.next(); 
	            System.out.print("ID: " + questionIte.getIdQuestion()); 
	            idPregunta = questionIte.getIdQuestion();
	            System.out.print("  Texto: " + questionIte.getText()); 
	            pregunta = questionIte.getText();
	            System.out.println("  Categoria: " + questionIte.getCategory()); 
	            categoria = questionIte.getCategory(); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	public void listAnswer(int id_question){
		
	      Session session = sesion.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List answer = session.createQuery("FROM Answer WHERE id_question =  '"+id_question+"'").list(); 
	         for (Iterator iterator = answer.iterator(); iterator.hasNext();){
	        	 for(int i = 0;i<4;i++){
		        	if(i == 0){	 
			            Answer answerList = (Answer) iterator.next(); 
			            System.out.print("ID: " + answerList.getIdAnswer()); 
			            idRespuesta = answerList.getIdAnswer();
			            System.out.print("  Texto: " + answerList.getText()); 
			            textoRespuesta1 = answerList.getText();
			            System.out.println("  Es correcta: " + answerList.getIsCorrect()); 
			            iscorrect1 = answerList.getIsCorrect();
			            System.out.println("  Id Pregunta: " + answerList.getIdQuestion()); 
		        	}else if(i == 1){
		        		Answer answerList = (Answer) iterator.next(); 
			            System.out.print("ID: " + answerList.getIdAnswer()); 
			            idRespuesta = answerList.getIdAnswer();
			            System.out.print("  Texto: " + answerList.getText()); 
			            textoRespuesta2 = answerList.getText();
			            System.out.println("  Es correcta: " + answerList.getIsCorrect()); 
			            iscorrect2 = answerList.getIsCorrect();
			            System.out.println("  Id Pregunta: " + answerList.getIdQuestion()); 
		        	}
		        	else if(i == 2){
		        		Answer answerList = (Answer) iterator.next(); 
			            System.out.print("ID: " + answerList.getIdAnswer()); 
			            idRespuesta = answerList.getIdAnswer();
			            System.out.print("  Texto: " + answerList.getText()); 
			            textoRespuesta3 = answerList.getText();
			            System.out.println("  Es correcta: " + answerList.getIsCorrect()); 
			            iscorrect3 = answerList.getIsCorrect();
			            System.out.println("  Id Pregunta: " + answerList.getIdQuestion()); 
		        	}
		        	else if(i == 3){
		        		Answer answerList = (Answer) iterator.next(); 
			            System.out.print("ID: " + answerList.getIdAnswer()); 
			            idRespuesta = answerList.getIdAnswer();
			            System.out.print("  Texto: " + answerList.getText()); 
			            textoRespuesta4 = answerList.getText();
			            System.out.println("  Es correcta: " + answerList.getIsCorrect()); 
			            iscorrect4 = answerList.getIsCorrect();
			            System.out.println("  Id Pregunta: " + answerList.getIdQuestion()); 
		        	}
	           
	         }
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	
	public void deleteQuestion(int idQestion){
	      Session session = sesion.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Question pregunta = 
	                   (Question)session.get(Question.class, idQestion); 
	         session.delete(pregunta); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	public void updatePregunta(int idQuestion, String text, String category ){
	      Session session = sesion.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Question pregunta = 
	                   (Question)session.get(Question.class, idQuestion); 
	         pregunta.setIdQuestion(idQuestion);
	         pregunta.setText(text);
	         pregunta.setCategory(category);
			 session.update(pregunta); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	public void updateRespuesta(String text, Boolean isCorrect, Integer idQuestion ){
	      Session session = sesion.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Answer respuesta = 
	                   (Answer)session.get(Answer.class, idQuestion); 
	         respuesta.setIdAnswer(idQuestion);
	         respuesta.setText(text);
	         respuesta.setIsCorrect(isCorrect);
			 session.update(respuesta); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	public void listUpdateAnswer(int id_question, String text,boolean isCorrect, int idQuestion ){
		
	      Session session = sesion.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List answer = session.createQuery("FROM Answer WHERE id_question =  '"+id_question+"'").list(); 
	         for (Iterator iterator = answer.iterator(); iterator.hasNext();){
	        	 for(int i = 0;i<4;i++){
		        	if(i == 0){	 
			            Answer answerList = (Answer) iterator.next(); 
			            updateRespuesta(text, isCorrect, idQuestion);
		        	}else if(i == 1){
		        		Answer answerList = (Answer) iterator.next(); 
		        		updateRespuesta(text, isCorrect, idQuestion);
		        	}
		        	else if(i == 2){
		        		Answer answerList = (Answer) iterator.next(); 
		        		updateRespuesta(text, isCorrect, idQuestion); 
		        	}
		        	else if(i == 3){
		        		Answer answerList = (Answer) iterator.next(); 
		        		updateRespuesta(text, isCorrect, idQuestion);
		        	}
	           
	         }
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	
}
