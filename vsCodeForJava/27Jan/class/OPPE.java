class OPPE {
    public static void main(String[] args) {


         Employee raju = new Employee(30000, 20, 250);
            System.out.println(raju.getWage());
            }
        // Define the Employee class
        static class Employee {
            int baseSalary;
            int overtime;
            int unitRate;

            Employee(int baseSalary, int overtime, int unitRate) {
                this.baseSalary = baseSalary;
                this.overtime = overtime;
                this.unitRate = unitRate;
            }

            int getWage() {
                return this.baseSalary + this.overtime * this.unitRate;
            }
        }

       
   
}
