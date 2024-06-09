

import java.util.Random;

public class Simulator<E extends Customer<E> {
    private PriortyMin min;
    private PriortyMax max;
    private double MoneyMade;

    private void SimulateRegularQueue() {
        RegularQueue Reg = new RegularQueue();
        for (int i = 0; i < 1000; i++) {
         for (int j = 0; j < 120; j++) {
            if(Reg.size() <= 20){
                Random newCustomer = new Random();
                double probability = newCustomer.nextDouble();
             if (probability <= 0.55) {

                    Customer c = new Customer();
                    String C = c.toString();


                    Random rn = new Random();
                    double d = rn.nextDouble();     // random value in range 0.0 - 1.0
                    if (d <= 0.70) {
                        c.setType(1);
                        c.setPrice(2.00);
                        MoneyMade += c.getPrice();
                        Random r = new Random();
                        c.setServiceTime(r.nextInt(Math.abs(120 - 60) / 15));
                        C = c.toString();
                        Reg.offer(C);
                        if (Reg.get(0) != null) {
                            String S = C.substring(C.indexOf("serviceTime=") + 13);
                            String[] res = S.split(" ", 0);
                            int TimeDown = Integer.parseInt(res[0]);
                            if(TimeDown - 1 > 0) {
                                String[] D = C.split(" ", 0);
                                String TimeDown2 = new String(D[0] +  " " + (TimeDown - 1) + " " +res[1]+ " " +res[2]+ ")");

                                Reg.theData.set(0, TimeDown2);


                      } else{
                                Reg.poll();}


                        }

                    } else {
                        c.setType(2);
                        c.setPrice(5.00);
                        MoneyMade += c.getPrice();
                        Random r = new Random();
                        c.setServiceTime(r.nextInt(Math.abs(300 - 120) / 15));
                        if(c.getServiceTime() < 1){
                            c.setServiceTime(2);
                        }
                        C = c.toString();
                        Reg.offer(C);
                        if (Reg.get(0) != null) {
                            String S = C.substring(C.indexOf("serviceTime=") + 13);
                            String[] res = S.split(" ", 0);
                            int TimeDown = Integer.parseInt(res[0]);
                            if(TimeDown - 1 > 0) {
                                String[] D = C.split(" ", 0);
                                String TimeDown2 = new String(D[0] +" "+ (TimeDown - 1) + " " +res[1] + res[2] + ")");

                                Reg.theData.set(0, TimeDown2);


                            } else{
                                Reg.poll();}
                        }
                    }

                }
         System.out.println(MoneyMade);
            } else{
               String C =  Reg.get(0).toString();
                String S = C.substring(C.indexOf("serviceTime=") + 13);
                String[] res = S.split(" ", 0);
                int TimeDown = Integer.parseInt(res[0]);
                if(TimeDown - 1 > 0) {
                    String[] D = C.split(" ", 0);
                    String TimeDown2 = new String(D[0]+" " + (TimeDown - 1) + " " + D[1]+ D[2]+  ")");

                    Reg.theData.set(0, TimeDown2);


                } else{
                    Reg.poll();}

            }
        }}}
    private void SimulateSpecialCoffeePriortyQueue() {
        PriortyMax Reg = new PriortyMax();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 120; j++) {
                if(Reg.size() <= 20){
                    Random newCustomer = new Random();
                    double probability = newCustomer.nextDouble();
                    if (probability <= 0.55) {

                        Customer c = new Customer();
                        String C = c.toString();


                        Random rn = new Random();
                        double d = rn.nextDouble();     // random value in range 0.0 - 1.0
                        if (d <= 0.70) {
                            c.setType(1);
                            c.setPrice(2.00);
                            MoneyMade += c.getPrice();
                            Random r = new Random();
                            c.setServiceTime(r.nextInt(Math.abs(120 - 60) / 15));
                            C = c.toString();
                            Reg.offer(String.valueOf(c.getType()));
                            if (Reg.get(0) != null) {
                                String S = C.substring(C.indexOf("serviceTime=") + 13);
                                String[] res = S.split(" ", 0);
                                int TimeDown = Integer.parseInt(res[0]);
                                if(TimeDown - 1 > 0) {
                                    String[] D = C.split(" ", 0);
                                    String TimeDown2 = new String(D[0] +  " " + (TimeDown - 1) + " " +res[1]+ " " +res[2]+ ")");

                                    Reg.theData.set(0, TimeDown2);


                                } else{
                                    Reg.poll();}


                            }

                        } else {
                            c.setType(2);
                            c.setPrice(5.00);
                            MoneyMade += c.getPrice();
                            Random r = new Random();
                            c.setServiceTime(r.nextInt(Math.abs(300 - 120) / 15));
                            if(c.getServiceTime() < 1){
                                c.setServiceTime(2);
                            }
                            C = c.toString();
                            Reg.offer(String.valueOf(c.getType()));
                            if (Reg.get(0) != null) {
                                String S = C.substring(C.indexOf("serviceTime=") + 13);
                                String[] res = S.split(" ", 0);
                                int TimeDown = Integer.parseInt(res[0]);
                                if(TimeDown - 1 > 0) {
                                    String[] D = C.split(" ", 0);
                                    String TimeDown2 = new String(D[0] +" "+ (TimeDown - 1) + " " +res[1] + res[2] + ")");

                                    Reg.theData.set(0, TimeDown2);


                                } else{
                                    Reg.poll();}
                            }
                        }

                    }
                    System.out.println(MoneyMade);
                } else{
                    String C =  Reg.get(0).toString();
                    String S = C.substring(C.indexOf("serviceTime=") + 13);
                    String[] res = S.split(" ", 0);
                    int TimeDown = Integer.parseInt(res[0]);
                    if(TimeDown - 1 > 0) {
                        String[] D = C.split(" ", 0);
                        String TimeDown2 = new String(D[0]+" " + (TimeDown - 1) + " " + D[1]+ D[2]+  ")");

                        Reg.theData.set(0, TimeDown2);


                    } else{
                        Reg.poll();}

                }
            }}}
    private void SimulateRegularCoffeePriortyQueue() {
        PriortyMin Reg = new PriortyMin();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 120; j++) {
                if(Reg.size() <= 20){
                    Random newCustomer = new Random();
                    double probability = newCustomer.nextDouble();
                    if (probability <= 0.55) {

                        Customer c = new Customer();
                        String C = c.toString();


                        Random rn = new Random();
                        double d = rn.nextDouble();     // random value in range 0.0 - 1.0
                        if (d <= 0.70) {
                            c.setType(1);
                            c.setPrice(2.00);
                            MoneyMade += c.getPrice();
                            Random r = new Random();
                            c.setServiceTime(r.nextInt(Math.abs(120 - 60) / 15));
                            C = c.toString();
                            Reg.offer(String.valueOf(c.getType()));
                            if (Reg.get(0) != null) {
                                String S = C.substring(C.indexOf("serviceTime=") + 13);
                                String[] res = S.split(" ", 0);
                                int TimeDown = Integer.parseInt(res[0]);
                                if(TimeDown - 1 > 0) {
                                    String[] D = C.split(" ", 0);
                                    String TimeDown2 = new String(D[0] +  " " + (TimeDown - 1) + " " +res[1]+ " " +res[2]+ ")");

                                    Reg.theData.set(0, TimeDown2);


                                } else{
                                    Reg.poll();}


                            }

                        } else {
                            c.setType(2);
                            c.setPrice(5.00);
                            MoneyMade += c.getPrice();
                            Random r = new Random();
                            c.setServiceTime(r.nextInt(Math.abs(300 - 120) / 15));
                            if(c.getServiceTime() < 1){
                                c.setServiceTime(2);
                            }
                            C = c.toString();
                            Reg.offer(String.valueOf(c.getType()));
                            if (Reg.get(0) != null) {
                                String S = C.substring(C.indexOf("serviceTime=") + 13);
                                String[] res = S.split(" ", 0);
                                int TimeDown = Integer.parseInt(res[0]);
                                if(TimeDown - 1 > 0) {
                                    String[] D = C.split(" ", 0);
                                    String TimeDown2 = new String(D[0] +" "+ (TimeDown - 1) + " " +res[1] + res[2] + ")");

                                    Reg.theData.set(0, TimeDown2);


                                } else{
                                    Reg.poll();}
                            }
                        }

                    }
                    System.out.println(MoneyMade);
                } else{
                    String C =  Reg.get(0).toString();
                    String S = C.substring(C.indexOf("serviceTime=") + 13);
                    String[] res = S.split(" ", 0);
                    int TimeDown = Integer.parseInt(res[0]);
                    if(TimeDown - 1 > 0) {
                        String[] D = C.split(" ", 0);
                        String TimeDown2 = new String(D[0]+" " + (TimeDown - 1) + " " + D[1]+ D[2]+  ")");

                        Reg.theData.set(0, TimeDown2);


                    } else{
                        Reg.poll();}

                }
            }}}
        public static void main (String[]args){
            Simulator s = new Simulator();
            s.SimulateRegularCoffeePriortyQueue();
        }
    }
