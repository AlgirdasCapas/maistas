package org.example;

import org.example.maitinimoIstaiga.MaitinimoIstaiga;
import org.example.maitinimoIstaiga.MaitinimoIstaigaDAO;
import org.example.maitinimoIstaiga.utils.BCryptPassword;
import org.example.user.User;
import org.example.user.UserDAO;
import org.example.user.UserSingleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean arVeikia = true;
        while (arVeikia) {
            System.out.println("*** Maisto užsakymo programa \"maistas\" ***.\n\n" +
                    "Įveskite pasirinktą veiksmą ( 1 arba 2 ):" +
                    "\n >>> 1. PRISIJUNGIMAS" +
                    "\n >>> 2. REGISTRACIJA\n");
            Scanner ivestis1 = new Scanner(System.in);
            int arReg = ivestis1.nextInt();

            if (arReg == 1) {
                System.out.println();
                break;
            } else if (arReg == 2) {
                System.out.println("Administratorius (įveskite 1) ar klientas (įveskite 2)?");
                Scanner ivestis3 = new Scanner(System.in);
                int role = ivestis3.nextInt();

                User vartotojas1 = null;
                if (role == 1) {
                    System.out.println("Vardas?");
                    Scanner ivestis4 = new Scanner(System.in);
                    String vardas = ivestis4.nextLine();
                    System.out.println("Slaptažodis? ");
                    String password = ivestis4.nextLine();
                    System.out.println("El. paštas?");
                    String email = ivestis4.nextLine();



                    vartotojas1 = new User(0, vardas, password, email, role);
                } else if (role == 2) {
                    System.out.println("Vardas?");
                    Scanner ivestis4 = new Scanner(System.in);
                    String vardas = ivestis4.nextLine();
                    System.out.println("Slaptažodis? ");
                    String pavarde = ivestis4.nextLine();
                    System.out.println("El. paštas?");
                    String email = ivestis4.nextLine();


                    vartotojas1 = new User(0, vardas, pavarde, email, role);
                } else {
                    System.out.println("Tokio pasirinkimo nėra");
                }
                kurtiVartotoja(vartotojas1);
                break;
            } else {
                System.out.println("Tokio pasirinkimo nėra");
            }
        }//pradinis while

        while (arVeikia == true) {
            Scanner ivestis4 = new Scanner(System.in);
            System.out.println("Iveskite vartotojo vardą: ");
            String vardas = ivestis4.nextLine();
            System.out.println("Iveskite slaptažodį: ");
            String slaptazodis = ivestis4.nextLine();
            String passwordDataBase = UserDAO.getBCryptPassword(vardas);

            if (passwordDataBase.isEmpty()) {
                System.out.println("Wrong username or password");
            } else {
                boolean isValidPassword = BCryptPassword.checkPassword(slaptazodis, passwordDataBase);
                if (isValidPassword) {
                    System.out.println("Jūs prisijungėte prie sistemos");
                    UserSingleton userSingleton = UserSingleton.getInstance();
                    userSingleton.setUsername(vardas);
                    System.out.println("Iveskite rolę: 1=ADMIN, 2=vartotojas ");
                    int role = ivestis4.nextInt();
                    if (role == 1) {
                        System.out.println("Meniu\n Pridėti maitinimo įstaigą - įveskite 1\n Ieškoti maitinimo įstaigos - įveskite 2\n Ištrinti maitinimo įstaigą - įveskite 3");
                        Scanner ivestis2 = new Scanner(System.in);
                        int admMeniu = ivestis2.nextInt();

                        if (admMeniu == 1) {
                            kurtiIstaiga();
                            break;
                        } else if (admMeniu == 2) {
                            ieskotiIstaigos();
                            break;
                        }
                        else if (admMeniu == 3) {
                            trntiIstaiga();
                            break;
                        }else {
                            System.out.println("Tokio pasirinkimo nėra");
                        }
                    }
                    else if (role == 2){
                        System.out.println("Meniu\n Ieškoti maitinimo įstaigos - įveskite 1\n pasirinkti maitinimo įstaigą - įveskite 2");
                        Scanner ivestis2 = new Scanner(System.in);
                        int admMeniu = ivestis2.nextInt();

                        if (admMeniu == 1) {
                            ieskotiIstaigos();
                            break;
                        } else if (admMeniu == 2) {
                            ieskotiIstaigos();
                            break;
                        } else {
                            System.out.println("Tokio pasirinkimo nėra");
                        }
                    }
                } else {
                    System.out.println("Wrong username or password");
                    break;
                }
            }


        }//dashboard while



    }//main


    static void ieskotiIstaigos(){
        System.out.println("Įstaigos paieška DB-ėje pagal adresą. \nĮveskite įstaigos adreasą, kuriame norite ieškoti:");
        Scanner ivestis = new Scanner(System.in);
        String miestas = ivestis.nextLine();
        MaitinimoIstaigaDAO.ieskotiIstaigos(miestas);
    }


    static void kurtiIstaiga(){
        System.out.println("Įstaigos pavadinimas?");
        Scanner ivestis1 = new Scanner(System.in);
        String pavadinimas = ivestis1.nextLine();
        System.out.println("Įstaigos kodas?: ");
        Scanner ivestis2 = new Scanner(System.in);
        String kodas = ivestis2.nextLine();
        System.out.println("Įstaigos adresas?");
        String adresas = ivestis1.nextLine();

        MaitinimoIstaiga istaiga1 = new MaitinimoIstaiga(pavadinimas, kodas, adresas);
        MaitinimoIstaigaDAO.kurti(istaiga1);
    }


    static void kurtiVartotoja(User vartotojas){
        UserDAO.kurti(vartotojas);
    }

    static void trntiIstaiga(){
        System.out.println("Iveskite įstaigos, kurią norite šalinti id: ");
        Scanner ivestis1 = new Scanner(System.in);
        int id = ivestis1.nextInt();
        MaitinimoIstaigaDAO.delete(id);
    }
}