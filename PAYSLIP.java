/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payslip;
import java.util.Scanner;
 abstract class Employee
{
int Emp_id;
String Emp_name;
public abstract void computepay();
Employee(int id,String name)
{
this.Emp_id=id;
this.Emp_name=name;

}
}
class Programmer extends Employee
{
double BP,Gross_salary,Net_salary;
public Programmer(int id,String name)
{
super(id,name);
}
 public void computepay()
{
System.out.print("Enter Basic Pay:");
Scanner input=new Scanner(System.in);
BP=input.nextDouble();
double DA,HRA,PF,Fund;
DA=(BP*97/100);
HRA=(BP*10/100);
PF=(BP*12/100);
Fund=(BP*0.1/100);
Gross_salary=BP+DA+HRA;
Net_salary=BP+DA+HRA-(PF+Fund);
System.out.println("Emp_ID: "+Emp_id);
System.out.println("Emp_Name: "+Emp_name);
System.out.println("Gross Pay: "+Gross_salary);
System.out.println("Net Pay: "+Net_salary);
}
public void disp()
{
System.out.println("Emp_ID: "+Emp_id);
System.out.println("Emp_Name: "+Emp_name);
System.out.println("Gross Pay: "+Gross_salary);
System.out.println("Net Pay: "+Net_salary);
    
}}
class manager extends Employee
{
double BP,Gross_salary,Net_salary;
public manager(int id,String name)
{
super(id,name);
}
public void computepay()
{
System.out.print("Enter Basic Pay:");
Scanner input=new Scanner(System.in);
BP=input.nextDouble();

double DA,HRA,PF,Fund;
DA=(BP*97/100);
HRA=(BP*10/100);
PF=(BP*15/100);
Fund=(BP*0.3/100);
Gross_salary=BP+DA+HRA;
Net_salary=BP+DA+HRA-(PF+Fund);
System.out.println("Emp_ID: "+Emp_id);
System.out.println("Emp_Name: "+Emp_name);
System.out.println("Gross Pay: "+Gross_salary);
System.out.println("Net Pay: "+Net_salary);
}
public void disp()
{
System.out.println("Emp_ID: "+Emp_id);
System.out.println("Emp_Name: "+Emp_name);
System.out.println("Gross Pay: "+Gross_salary);
System.out.println("Net Pay: "+Net_salary);    
}
}
class hr extends Employee
{
double BP,Gross_salary,Net_salary;
public hr(int id,String name)
{
super(id,name);
}
public void computepay()
{
System.out.print("Enter Basic Pay:");
Scanner input=new Scanner(System.in);
BP=input.nextDouble();
double DA,HRA,PF,Fund;
DA=(BP*97/100);
HRA=(BP*10/100);
PF=(BP*10/100);
Fund=(BP*0.4/100);
Gross_salary=BP+DA+HRA;
Net_salary=BP+DA+HRA-(PF+Fund);
System.out.println("Emp_ID: "+Emp_id);
System.out.println("Emp_Name: "+Emp_name);
System.out.println("Gross Pay: "+Gross_salary);
System.out.println("Net Pay: "+Net_salary);
}
public void disp()
{
System.out.println("Emp_ID: "+Emp_id);
System.out.println("Emp_Name: "+Emp_name);
System.out.println("Gross Pay: "+Gross_salary);
System.out.println("Net Pay: "+Net_salary);    
}
}
interface validate
{
    public int idintp(int a,int b,int c,int d,Programmer[] p, manager[] m,hr[] h);
    public void search(int a, int b, int c,int d,Programmer[] p,manager[] m,hr [] h);
}
class validate1 implements validate
{
 public int idintp(int a,int b, int c,int d,Programmer[] p,manager[] m,hr[] h)
 {
     for(int f=0;f<c;f++)
                {
              if(m[f].Emp_id==a)
                  return 1;   }
     for(int f=0;f<b;f++)
                {
              if(p[f].Emp_id==a)
                  return 1;   }
     for(int f=0;f<d;f++)
                {
              if(h[f].Emp_id==a)
                  return 1;   }
     return 0;
 }
 public void search(int a, int b, int c,int d,Programmer[] p,manager[] m,hr [] h)
 { int found=0;
     for(int f=0;f<c;f++)
                {
              if(m[f].Emp_id==a){
                 System.out.println("Job: manager");
                  m[f].disp();  found=1; }}
     for(int f=0;f<b;f++)
                {
              if(p[f].Emp_id==a){
                  p[f].disp(); 
                System.out.println("Job: Programmer"); found =1;}}
     for(int f=0;f<d;f++)
                {
              if(h[f].Emp_id==a){
                  h[f].disp();  
                System.out.println("Job: hr");found =1;}}
     if(found==0)
     {
         System.out.println("Employee not found!");
     }
 }
}

/**
 *
 * @author Dell
 */
public class PAYSLIP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice = 4;
        String name;
        int id;
        Programmer[ ] p;
        p= new Programmer[10];
        manager [] m;
        m = new manager[10];
        hr [] h;
        h = new hr[10];
           int i=0;
            int j=0;
            int k=0;
        while(choice !=0){
        System.out.println("Enter 1 to add an employee"+"\n"+"Enter 2 to edit the records"+"\n"+"Enter 3 to display records"+"\nEnter 4 to search for an employee\n"+"Enter 0 to exit");
        Scanner in=new Scanner(System.in);
        choice=in.nextInt();
        switch(choice){
            
            case 1: 
                int choice1;
            System.out.println("Enter 1 to add a Programmer \nEnter 2 to add a manager \nEnter 3 to add a hr\nEnter 0 to exit");
            choice1=in.nextInt();
            System.out.println("Enter the name of the employee");
            name=in.next();
            System.out.println("Enter the id of the employee");
            id=in.nextInt();
         validate1 v= new validate1();
         if(v.idintp(id,i,j,k,p,m,h)== 1)
             System.out.println("Employee id already exists");
          else
         {
            switch(choice1)
                
            {
                case 1:
             {
            p[i] = new Programmer(id,name);
              p[i].computepay();
              i=i+1;}
            break;
            case 2:
            m[j]=new manager(id,name);
            m[j].computepay();
            j=j+1;
            break;
            case 3: 
            h[k]=new hr(id,name);
             h[k].computepay();
             k=k+1;
            break;  
            case 0:
                break;
            
              default:
                System.out.println("Oops! Invalid input!!");
                break;
            }}
            break;
            case 2:
                
             int flag=1;
           System.out.println("Enter the id of the employee");
           id=in.nextInt();
                for(int f=0;f<j;f++)
                {
              if(m[f].Emp_id==id)
              { flag=0;
                  System.out.println("Enter 1 to edit name\nEnter 2 to edit basic pay");
                  int choicen;
                  choicen=in.nextInt();
                  if(choicen==1)
                  {
                     System.out.println("Enter name: ");
                     name=in.next();
                     m[f].Emp_name=name;
                     System.out.println("Successfully edited!!");
                  }
                  if(choicen==2)
                  {
                     m[f].computepay();
                     System.out.println("Successfully edited!!");
                  }
              }
                }              
                  for(int f=0;f<i;f++)
                {
              if(p[f].Emp_id==id)
              { flag=0;
                  System.out.println("Enter 1 to edit name\nEnter 2 to edit basic pay");
                  int choicen;
                  choicen=in.nextInt();
                  if(choicen==1)
                  {
                     System.out.println("Enter name: ");
                     name=in.next();
                     p[f].Emp_name=name;
                     System.out.println("Successfully edited!!");
                  }
                  if(choicen==2)
                  {
                     p[f].computepay();
                     System.out.println("Successfully edited!!");
                  }
              }
                }
                   for(int f=0;f<k;f++)
                {
              if(h[f].Emp_id==id)
              {
                  flag=0;
                  System.out.println("Enter 1 to edit name\nEnter 2 to edit basic pay");
                  int choicen;
                  choicen=in.nextInt();
                  if(choicen==1)
                  {
                     System.out.println("Enter name: ");
                     name=in.next();
                     h[f].Emp_name=name;
                     System.out.println("Successfully edited!!");
                  }
                  if(choicen==2)
                  {
                     h[f].computepay();
                     System.out.println("Successfully edited!!");
                  }
              }
                }
                   if(flag==1)
                   {
                       System.out.println("Id not found");
                   }
            break;
           
            case 3:
                 int choice2;
                 System.out.println("Enter 1 to view details of a Programmer \nEnter 2 to view details of a manager \nEnter 3 to view details of a hr\nEnter 4 to view all details\nEnter 0 to exit");
            choice2=in.nextInt();
                 switch(choice2){
            
            case 1: 
            double np=0;
                for(int f=0;f<i;f++)
                {
              p[f].disp();
               np=p[f].Net_salary+np;
                }
                System.out.println("Total net pay of the company for the programmers is: "+ np);
            break;
            case 2: 
                
           double np1=0;
                for(int f=0;f<j;f++)
                {
              m[f].disp();
               np1=m[f].Net_salary+np1;
                }
                System.out.println("Total net pay of the company for the managers is: "+ np1);
            break;
            case 3:
                double np2=0;
                for(int f=0;f<k;f++)
                {
              h[f].disp();
               np2=h[f].Net_salary+np2;
                }
                System.out.println("Total net pay of the company for the hr is: "+ np2);
            break;  
            case 0:
                break;
            case 4:
                for(int f=0;f<i;f++)
                {
              p[f].disp();
                }
 for(int f=0;f<j;f++)
                {
              m[f].disp();
                }
  for(int f=0;f<k;f++)
                {
              h[f].disp();
                }
              break;
              default:
                System.out.println("Oops! Invalid input!!");
                break;
            }
            break;
            case 4:
                System.out.println("Enter the id of the employee");
                id=in.nextInt();
                validate1 x = new validate1();
         x.search(id,i,j,k,p,m,h);
         break;
            case 0:
                System.exit(0);
            break;
            default:
                System.out.println("Oops! Invalid input!!");
                break;
        }
// TODO code application logic here
    }   
    }}
        

