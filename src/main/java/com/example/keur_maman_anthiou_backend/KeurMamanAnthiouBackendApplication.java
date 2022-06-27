package com.example.keur_maman_anthiou_backend;
import com.example.keur_maman_anthiou_backend.entities.*;
import com.example.keur_maman_anthiou_backend.repositories.*;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Transactional
public class KeurMamanAnthiouBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeurMamanAnthiouBackendApplication.class, args);
    }
//    @Bean
//    CommandLineRunner sendSms(){
//        return (args) -> {
//            Twilio.init("ACf6473fbd9ba92f0475cd1719f77c567e", "a43510f7cf41c3a6f54aca1cb0b65880");
//            Message message = Message.creator(
//                            new com.twilio.type.PhoneNumber("773813060"),
//                            new com.twilio.type.PhoneNumber("+12183929372"),
//                            "McAvoy or Stewart? These timelines can get so confusing.")
//                    .create();
//            System.out.println(message.getSid());
//        };
//    }
//    @Bean
//    CommandLineRunner start(AdministrateurRepository administrateurRepository,
//                            EleveRepository eleveRepository,
//                            ParentRepository parentRepository,
//                            ProfesseurRepository professeurRepository,
//                            GenreRepository genreRepository,
//                            MatiereRepository matiereRepository,
//                            ClasseRepository classeRepository,
//                            EvaluationRepository evaluationRepository){
//        return  args -> {
//            Collection<Genre> genres = new ArrayList<>();
//            Genre genre1 = new Genre(null,"Masculin");
//            Genre genre2 = new Genre(null,"Feminin");
//            genres.add(genre1);
//            genres.add(genre2);
//            genreRepository.saveAll(genres);
//
//            List<Matiere> matieres = new ArrayList<>();
//            Matiere matiere1 = new Matiere();
//            matiere1.setCoefficient(4);
//            matiere1.setLibelle("Mathematiques");
//            Matiere matiere2 = new Matiere();
//            matiere2.setCoefficient(2);
//            matiere2.setLibelle("HISTO-GEO");
//            matieres.add(matiere1);
//            matieres.add(matiere2);
//            Random aleatoire = new Random();
//            matiereRepository.saveAll(matieres);
//
//            Collection<Administrateur> administrateurs = new ArrayList<>();
//            Administrateur admin1 = new Administrateur(null, "Papa Ibrahima", "NDIAYE", "papi", "1234", "Diroga Cherif", true,genreRepository.findById(1L).orElse(null), "776692537");
//            Administrateur admin2 = new Administrateur(null, "Cheikh", "SOW", "cheikh", "1234", "Malika", true,genreRepository.findById(1L).orElse(null), "776622537");
//            Administrateur admin3 = new Administrateur(null, "Jacques Etienne", "NDIAYE", "jacques", "1234", "Keur Massar", true,genreRepository.findById(1L).orElse(null), "776622588");
//            Administrateur admin4 = new Administrateur(null, "Maimouna", "DIALLO", "maimouna", "1234", "Maristes", true,genreRepository.findById(2L).orElse(null), "776622521");
//            administrateurs.add(admin1);
//            administrateurs.add(admin2);
//            administrateurs.add(admin3);
//            administrateurs.add(admin4);
//            administrateurRepository.saveAll(administrateurs);
//
//            Collection<Professeur> professeurs = new ArrayList<>();
//            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//            for(int i=0;i<20;i++){
//                Professeur prof = new Professeur(null, RandomString.make(12), RandomString.make(7).toUpperCase(), "professeur"+RandomString.make(4), "1234", "Diroga Cherif", (Math.random()<0.5)?true:false,genreRepository.findById((Math.random()<0.5)?1L:2L).orElse(null),"77"+aleatoire.nextInt(7,9999999),df.parse("12-12-2000"),matiereRepository.findById((Math.random()<0.5)?1L:2L).orElse(null));
//                professeurs.add(prof);
//            }
//            professeurRepository.saveAll(professeurs);
//
//            List<Classe> classes = new ArrayList<>();
//            Classe CI = new Classe(null,"CI",null);
//            Classe CP = new Classe(null,"CP",null);
//            Classe CE1 = new Classe(null,"CE1",null);
//            Classe CE2 = new Classe(null,"CE2",null);
//            Classe CM1 = new Classe(null,"CM1",null);
//            Classe CM2 = new Classe(null,"CM2",null);
//            Classe six = new Classe(null,"6eme",null);
//            Classe cinq = new Classe(null,"5eme",null);
//            Classe quatre = new Classe(null,"4eme",null);
//            Classe trois = new Classe(null,"3eme",null);
//            Classe seconde = new Classe(null,"2nd",null);
//            Classe premiere = new Classe(null,"1ere",null);
//            Classe terminal = new Classe(null,"terminale",null);
//
//            classes.add(CI);
//            classes.add(CP);
//            classes.add(CE1);
//            classes.add(CE2);
//            classes.add(CM1);
//            classes.add(CM2);
//            classes.add(six);
//            classes.add(cinq);
//            classes.add(quatre);
//            classes.add(trois);
//            classes.add(seconde);
//            classes.add(premiere);
//            classes.add(terminal);
//            classeRepository.saveAll(classes);
//
//            Collection<Parent> parents = new ArrayList<>();
//            for (int i=1; i<=20;i++){
//               Parent parent = new Parent(null,RandomString.make(8),RandomString.make(8), RandomString.make(8)+"parent", "1234", RandomString.make(8), (Math.random()<0.7)?true:false,(Math.random()<0.7)?genre1:genre2,"1770"+aleatoire.nextInt(9,99999), "1770"+aleatoire.nextInt(7,9999999)) ;
//               parents.add(parent);
//            }
//            parentRepository.saveAll(parents);
//            parents.forEach(parent -> {
//                for (int i=1;i<4;i++){
//                    Classe classe = classes.get((int)Math.ceil(Math.random()*classes.size()-1));
//                    try {
//                        Eleve eleve = new Eleve(null,RandomString.make(8),RandomString.make(8), RandomString.make(8)+"parent", "1234", RandomString.make(8), (Math.random()<0.7)?true:false,(Math.random()<0.7)?genre1:genre2, classe.getLibelle()+"-"+new Date()+"-"+parent.getPrenom().substring(1).toUpperCase()+parent.getNom().substring(1).toUpperCase(),df.parse("12-12-2000"),parent, classe);
//                        eleveRepository.save(eleve);
//                    } catch (ParseException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            });
//            List<String> dates = new ArrayList<>();
//            dates.add("12-04-2022");
//            dates.add("21-07-2022");
//            dates.add("01-01-2022");
//            dates.add("22-02-2022");
//            dates.add("12-03-2022");
//            dates.add("12-11-2021");
//            dates.add("12-10-2021");
//            dates.add("10-11-2021");
//            for(int i=1;i<=200;i++){
//                Matiere matiere = matieres.get((int)Math.ceil(Math.random()*matieres.size()-1));
//                List<Eleve> eleves = eleveRepository.findAll();
//                Eleve eleve = eleves.get((int)Math.ceil(Math.random()*eleves.size()-1));
//                Evaluation evaluation = new Evaluation(null,Math.random()*20,df.parse(dates.get((int) Math.floor(Math.random()*dates.size()))), matiere, eleve);
//                evaluationRepository.save(evaluation);
//            }
//
//        };
//    }
}
