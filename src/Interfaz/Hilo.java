/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static java.lang.Math.random;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author frank
 */
public class Hilo implements Runnable {

    private int email;
    private int password;
    private String apellidoP;
    private String apellidoM;
    private String nombreU;
    private String typeU;
    private int delay;
    private int numberRequest;
    private JTextArea caja;
    private String ip;

    private double aHonesto;
    private double aEnviarA;
    private double aEmpieza;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCaja(JTextArea caja) {
        this.caja = caja;
    }

    public void setaHonesto(int aHonesto) {
        this.aHonesto = aHonesto;
    }

    public void setaEnviarA(int aEnviarA) {
        this.aEnviarA = aEnviarA;
    }

    public void setaEmpieza(int aEmpieza) {
        this.aEmpieza = aEmpieza;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public void setTypeU(String typeU) {
        this.typeU = typeU;

    }

    public void setRequestFS(int requestFS) {
        this.delay = requestFS;
    }

    public void setNumberRequest(int numberRequest) {
        this.numberRequest = numberRequest;
    }

    /*public void setEstado(boolean estado) {
        this.estado = estado;
    }*/
    public void loop() throws InterruptedException {
        double orden[] = new double[3];
        if (aHonesto > aEnviarA && aHonesto > aEmpieza) {
            orden[0] = aHonesto;
            System.out.println("aHonesto");
            if (aEnviarA > aEmpieza) {
                orden[1] = aEnviarA;
                orden[2] = aEmpieza;
                //este for debemos dejarlo con otra variable en lugar de x
                for (int x = 0; x < numberRequest; x++) {
                    double i = Math.random() * 99;
                    System.out.println("el random = " + i);

                    if (i < aEmpieza) {
                        AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                    } else {
                        if (i > aEmpieza && i < aEnviarA) {
                            AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                        } else {
                            AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                        }
                    }

                    TimeUnit.MILLISECONDS.sleep(delay);
                }
            } else {
                orden[2] = aEnviarA;
                orden[1] = aEmpieza;

                for (int x = 0; x < numberRequest; x++) {

                    double i = Math.random() * 99;
                    System.out.println("el random = " + i);

                    if (i < aEnviarA) {
                        AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                    } else {
                        if (i > aEnviarA && i < aEmpieza) {
                            AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                        } else {
                            AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                        }
                    }

                    TimeUnit.MILLISECONDS.sleep(delay);
                }
            }
        } else {
            if (aEnviarA > aHonesto && aEnviarA > aEmpieza) {
                System.out.println("aEnviar");
                orden[0] = aEnviarA;
                if (aHonesto > aEmpieza) {
                    orden[1] = aHonesto;
                    orden[2] = aEmpieza;

                    for (int x = 0; x < numberRequest; x++) {

                        double i = Math.random() * 99;
                        System.out.println("el random = " + i);

                        if (i < aEmpieza) {
                            AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                        } else {
                            if (i > aEmpieza && i < aHonesto) {
                                AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                            } else {
                                AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                            }
                        }

                        TimeUnit.MILLISECONDS.sleep(delay);
                    }
                } else {
                    if (aHonesto < aEmpieza) {
                        orden[2] = aHonesto;
                        orden[1] = aEmpieza;

                        for (int x = 0; x < numberRequest; x++) {

                            double i = Math.random() * 99;
                            System.out.println("el random = " + i);

                            if (i < aHonesto) {
                                AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                            } else {
                                if (i > aHonesto && i < aEmpieza) {
                                    AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                                } else {
                                    AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                }
                            }

                            TimeUnit.MILLISECONDS.sleep(delay);
                        }
                    } else {
                        //esto lo acabo de poner
                        if (aHonesto == aEmpieza) {
                            orden[0] = aEnviarA;
                            orden[1] = aHonesto;
                            orden[2] = aEmpieza;
                            System.out.println("son iguales honesto y aEmpieza");

                            for (int x = 0; x < numberRequest; x++) {

                                double i = Math.random() * 99;
                                System.out.println("el random = " + i);

                                if (i < aEnviarA && i < aEmpieza) {
                                    double elección = Math.random();
                                    if (elección < 0.5) {
                                        AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                    } else {
                                        AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                                    }
                                } else {
                                    AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                }

                                TimeUnit.MILLISECONDS.sleep(delay);
                            }

                        }
                    }

                }
            } else {
                if (aEmpieza > aHonesto && aEmpieza > aEnviarA) {
                    System.out.println("aEmpieza");
                    orden[0] = aEmpieza;
                    if (aHonesto > aEnviarA) {
                        orden[1] = aHonesto;
                        orden[2] = aEnviarA;

                        for (int x = 0; x < numberRequest; x++) {

                            double i = Math.random() * 99;
                            System.out.println("el random = " + i);

                            if (i < aEnviarA) {
                                AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                            } else {
                                if (i > aEnviarA && i < aHonesto) {
                                    AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                                } else {
                                    AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                }
                            }

                            TimeUnit.MILLISECONDS.sleep(delay);
                        }
                    } else {
                        orden[2] = aHonesto;
                        orden[1] = aEnviarA;

                        for (int x = 0; x < numberRequest; x++) {

                            double i = Math.random() * 99;
                            System.out.println("el random = " + i);

                            if (i < aHonesto) {
                                AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                            } else {
                                if (i > aHonesto && i < aEnviarA) {
                                    AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                                } else {
                                    AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                }
                            }

                            TimeUnit.MILLISECONDS.sleep(delay);
                        }
                    }
                } else {
                    if (aHonesto < aEnviarA && aHonesto < aEmpieza && aEnviarA == aEmpieza) {
                        orden[0] = aEnviarA;
                        orden[1] = aEmpieza;
                        orden[2] = aHonesto;
                        System.out.println("son iguales aEnviarA y aEmpieza");
                        for (int x = 0; x < numberRequest; x++) {

                            double i = Math.random() * 99;
                            System.out.println("el random = " + i);

                            if (i < aEnviarA && i < aEmpieza) {
                                double elección = Math.random();
                                if (elección < 0.5) {
                                    System.out.println("Enviar algo");
                                    AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                } else {
                                    System.out.println("Empieza en algún paso");
                                    AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                                }
                            } else {
                                System.out.println("Agente honesto");
                                AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                            }

                            TimeUnit.MILLISECONDS.sleep(delay);
                        }
                    } else {
                        if (aEmpieza < aHonesto && aEmpieza < aEnviarA && aHonesto == aEnviarA) {
                            orden[0] = aHonesto;
                            orden[1] = aEnviarA;
                            orden[2] = aEmpieza;

                            System.out.println("son iguales aEnviarA y aEmpieza");

                            for (int x = 0; x < numberRequest; x++) {

                                double i = Math.random() * 99;
                                System.out.println("el random = " + i);

                                if (i < aEnviarA && i < aEmpieza) {
                                    double elección = Math.random();
                                    if (elección < 0.5) {

                                        AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                    } else {
                                        AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                    }
                                } else {
                                    AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                                }  

                                TimeUnit.MILLISECONDS.sleep(delay);
                            }
                        } else {
                            if (aHonesto > aEnviarA && aHonesto == aEmpieza) {
                                orden[0] = aHonesto;
                                orden[1] = aEmpieza;
                                orden[2] = aEnviarA;

                                System.out.println("son iguales Honesto y aEmpieza");

                                for (int x = 0; x < numberRequest; x++) {

                                    double i = Math.random() * 99;
                                    System.out.println("el random = " + i);

                                    if (i < aHonesto && i < aEmpieza) {
                                        double elección = Math.random();
                                        if (elección < 0.5) {
                                            AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                        } else {
                                            AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip);
                                        }
                                    } else {
                                        AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip);
                                    }

                                    TimeUnit.MILLISECONDS.sleep(delay);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(orden[0]);
        System.out.println(orden[1]);
        System.out.println(orden[2]);

    }

    public String generateEmail() {

        String correo;

        switch (email) {
            case 0:
                correo = String.valueOf(letter()) + "_" + String.valueOf(letter()) + "@" + String.valueOf(letter()) + "." + String.valueOf(letter()) + ".com";
                return correo;

            case 1:
                correo = String.valueOf(letter()) + "_" + String.valueOf(letter()) + String.valueOf(number()) + "@" + String.valueOf(letter()) + "." + String.valueOf(letter()) + ".com";
                return correo;
            default:
                correo = String.valueOf(letter()) + "_" + String.valueOf(letter()) + "@" + String.valueOf(letter()) + "." + String.valueOf(letter()) + ".com";
                return correo;
        }

    }

    public String generatePassword() {

        String contrasena;

        switch (password) {
            case 0:
                contrasena = String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(number()) + String.valueOf(letter());
                return contrasena;
            case 1:
                contrasena = String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(number());
                return contrasena;
            default:
                contrasena = String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(number()) + String.valueOf(letter());
                return contrasena;
        }
    }

    public char letter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    public int number() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }

    public void run() {
        try {
            //caja.append("lalo");
            loop();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
