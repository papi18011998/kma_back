package com.example.keur_maman_anthiou_backend;
import com.example.keur_maman_anthiou_backend.entities.*;
import com.example.keur_maman_anthiou_backend.repositories.*;
import com.github.javafaker.Faker;
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
import java.util.stream.Stream;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.constraints.Size;

@SpringBootApplication
@Transactional
public class KeurMamanAnthiouBackendApplication {

    public static void main(String[] args) {SpringApplication.run(KeurMamanAnthiouBackendApplication.class, args);}
    @Bean
    public Faker getFaker(){
     return  new Faker();
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
    CommandLineRunner start(AdministrateurRepository administrateurRepository,
                            EleveRepository eleveRepository,
                            ParentRepository parentRepository,
                            ProfesseurRepository professeurRepository,
                            GenreRepository genreRepository,
                            MatiereRepository matiereRepository,
                            ClasseRepository classeRepository,
                            EvaluationRepository evaluationRepository,
                            ClasseProfesseurRepository classeProfesseurRepository,
                            EleveClasseRepository eleveClasseRepository,
                            RoleRepository roleRepository){
        return  args -> {
            // Create faker class
            // Generate ROLES
            Stream.of("ADMIN","PROFESSEUR","PARENT","ELEVE").forEach(roleName->{
                AppRole role = new AppRole();
                role.setRoleName(roleName);
                roleRepository.save(role);
            });
            Faker faker = new Faker(new Locale("fr_SN"));
            // Create Genres
            Collection<Genre> genres = new ArrayList<>();
            Genre genre1 = new Genre(null,"Masculin");
            Genre genre2 = new Genre(null,"Feminin");
            genres.add(genre1);
            genres.add(genre2);
            genreRepository.saveAll(genres);

            // Create Matieres
            List<Matiere> matieres = new ArrayList<>();
            Matiere matiere1 = new Matiere();
            matiere1.setCoefficient(4);
            matiere1.setLibelle("Mathematiques");
            Matiere matiere2 = new Matiere();
            matiere2.setCoefficient(2);
            matiere2.setLibelle("HISTO-GEO");
            Matiere matiere3 = new Matiere();
            matiere3.setCoefficient(3);
            matiere3.setLibelle("Français");
            Matiere matiere4 = new Matiere();
            matiere4.setCoefficient(3);
            matiere4.setLibelle("Anglais");
            Matiere matiere5 = new Matiere();
            matiere5.setCoefficient(3);
            matiere5.setLibelle("Espagnol");
            Matiere matiere6 = new Matiere();
            matiere6.setCoefficient(3);
            matiere6.setLibelle("Philosophie");
            Matiere matiere7 = new Matiere();
            matiere7.setCoefficient(3);
            matiere7.setLibelle("Sciences de la vie et de la Terre");
            matieres.add(matiere1);
            matieres.add(matiere2);
            matieres.add(matiere3);
            matieres.add(matiere4);
            matieres.add(matiere5);
            matieres.add(matiere6);
            matieres.add(matiere7);
            matiereRepository.saveAll(matieres);

            Random aleatoire = new Random();
            // Create Administrateurs
            Collection<Administrateur> administrateurs = new ArrayList<>();
            List<AppRole> roles =new ArrayList<>();
            roles.add(roleRepository.findByRoleName("ADMIN"));
            Administrateur admin1 = new Administrateur(null, "Papa Ibrahima", "NDIAYE", "papi", "1234", "Diroga Cherif", true,genreRepository.findById(1L).orElse(null), "776692537");
            Administrateur admin2 = new Administrateur(null, "Cheikh", "SOW", "cheikh", "1234", "Malika", true,genreRepository.findById(1L).orElse(null), "776622537");
            Administrateur admin3 = new Administrateur(null, "Jacques Etienne", "NDIAYE", "jacques", "1234", "Keur Massar", true,genreRepository.findById(1L).orElse(null), "776622588");
            Administrateur admin4 = new Administrateur(null, "Maimouna", "DIALLO", "maimouna", "1234", "Maristes", true,genreRepository.findById(2L).orElse(null), "776622521");

            admin1.setRoles(roles);
            admin2.setRoles(roles);
            admin3.setRoles(roles);
            admin4.setRoles(roles);

            administrateurs.add(admin1);
            administrateurs.add(admin2);
            administrateurs.add(admin3);
            administrateurs.add(admin4);
            administrateurRepository.saveAll(administrateurs);

            // Create Classes
            List<Classe> classes = new ArrayList<>();
            Classe CI = new Classe(null,"CI");
            Classe CP = new Classe(null,"CP");
            Classe CE1 = new Classe(null,"CE1");
            Classe CE2 = new Classe(null,"CE2");
            Classe CM1 = new Classe(null,"CM1");
            Classe CM2 = new Classe(null,"CM2");

            Classe sixieme = new Classe(null,"6eme");
            Classe cinquieme = new Classe(null,"5eme");
            Classe quatrieme = new Classe(null,"4eme");
            Classe troisieme = new Classe(null,"3eme");
            Classe seconde = new Classe(null,"2nd");
            Classe premiere = new Classe(null,"1ere");
            Classe terminale = new Classe(null,"Terminale");

            classes.add(CI);
            classes.add(CP);
            classes.add(CE1);
            classes.add(CE2);
            classes.add(CM1);
            classes.add(CM2);
            classes.add(sixieme);
            classes.add(cinquieme);
            classes.add(quatrieme);
            classes.add(troisieme);
            classes.add(seconde);
            classes.add(premiere);
            classes.add(terminale);
            classeRepository.saveAll(classes);

            // Create Professeurs
            List<Professeur> professeurs = new ArrayList<>();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            for(int i=0;i<20;i++){
                List<AppRole> role_professeur =new ArrayList<>();
                role_professeur.add(roleRepository.findByRoleName("PROFESSEUR"));
                Professeur prof = new Professeur(null, faker.name().firstName(),faker.name().lastName(), faker.name().firstName(), "1234", faker.address().streetName(), (Math.random()<0.5),genreRepository.findById((Math.random()<0.5)?1L:2L).orElse(null),"77"+aleatoire.nextInt(7,9999999),faker.date().between(df.parse("01-01-2010"),df.parse("01-01-2020")),matieres.get(aleatoire.nextInt(matieres.size())));
                prof.setRoles(role_professeur);
                professeurs.add(prof);
            }
            professeurRepository.saveAll(professeurs);
            // Create ProfesseurClasse
            for (int i=0;i<=30;i++){
                List<String> annee_scolaire = new ArrayList<>();
                annee_scolaire.add("2019-2020");
                annee_scolaire.add("2020-2021");
                annee_scolaire.add("2021-2022");
                List<ClasseProfesseur> annee_enseignes = new ArrayList<>();
                Professeur rand_professeur = professeurs.get(aleatoire.nextInt(professeurs.size()));
                Classe rand_classe = classes.get(aleatoire.nextInt(classes.size()));
                ClasseProfesseur classeProfesseur = new ClasseProfesseur(null,
                      annee_scolaire.get(aleatoire.nextInt(annee_scolaire.size())),
                      rand_classe,
                      rand_professeur);
                annee_enseignes.add(classeProfesseur);
                rand_professeur.setAnnees(annee_enseignes);
                rand_classe.setProfesseurs_classes(annee_enseignes);
              classeProfesseurRepository.save(classeProfesseur);
              professeurRepository.save(rand_professeur);
              classeRepository.save(rand_classe);
            }
            // Create Parents
            List<Parent> parents = new ArrayList<>();
            for(int i=0;i<20;i++){
                List<AppRole> role_parent =new ArrayList<>();
                role_parent.add(roleRepository.findByRoleName("PARENT"));
                Parent parent = new Parent(null, faker.name().firstName(), faker.name().lastName(), faker.name().firstName(), "1234", faker.address().streetName(),Math.random()<=0.5, (Math.random()<=0.5)?genre1:genre2,"77"+aleatoire.nextInt(7,9999999), "1770"+aleatoire.nextInt(9,9999999));
                parent.setRoles(role_parent);
                parents.add(parent);
                parentRepository.save(parent);
            }
            // Create Eleves
            parents.forEach(parent->{
                for (int i=0;i<aleatoire.nextInt(4);i++){
                    try {
                        List<AppRole> role_eleve =new ArrayList<>();
                        role_eleve.add(roleRepository.findByRoleName("ELEVE"));
                        Eleve eleve = new Eleve(null, faker.name().firstName(), faker.name().lastName(), null, "1234", faker.address().streetName(), Math.random()<=0.5, (Math.random()<=0.5)?genre1:genre2, null,null,faker.date().between(df.parse("01-01-2000"),df.parse("01-01-2017")),parent);
                        eleve.setRoles(role_eleve);
                        eleveRepository.save(eleve);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            // Create EleveClasse
            eleveRepository.findAll().forEach(eleve -> {
                List<String> annee_scolaire = new ArrayList<>();
                annee_scolaire.add("2019-2020");
                annee_scolaire.add("2020-2021");
                annee_scolaire.add("2021-2022");
                Classe rand_classe = classes.get(aleatoire.nextInt(classes.size()));
                eleve.setMatricule(rand_classe.getLibelle().substring(0,2).toUpperCase()+
                        '-' +'0'+aleatoire.nextInt(2,9)+
                        eleve.getParent().getPrenom().substring(0,1).toUpperCase()+
                        eleve.getParent().getNom().substring(0,1).toUpperCase());
                eleve.setLogin(eleve.getMatricule());
                EleveClasse eleveClasse = new EleveClasse(null,
                        annee_scolaire.get(aleatoire.nextInt(annee_scolaire.size())),eleve,rand_classe);
                eleveClasseRepository.save(eleveClasse);
                eleveRepository.save(eleve);
            });
            // Create Notes
            List<String> dates = new ArrayList<>();
            for(int i=1;i<=200;i++){
                Matiere matiere = matieres.get(aleatoire.nextInt(matieres.size()));
                List<Eleve> eleves = eleveRepository.findAll();
                Eleve eleve = eleves.get(aleatoire.nextInt(eleves.size()));
                Evaluation evaluation = new Evaluation(null,faker.number().numberBetween(0,20),faker.date().between(df.parse("01-10-2019"),df.parse("30-06-2022")), matiere, eleve);
                evaluationRepository.save(evaluation);
            }

        };
    }
}
