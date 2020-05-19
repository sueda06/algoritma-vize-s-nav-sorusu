
package benimsınavsorum;
import java.util.Scanner;
public class Benimsınavsorum {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
         menuGoster();
         boolean cikis=false;
         Televizyon tv = null;
        while(cikis!=true){
             System.out.println("seçim yapınız");
            int olustur=s.nextInt();
            switch(olustur){
                case 0:
                    cikis=true;
                    break;
                case 1:
                    System.out.println("bir televizyon nesnesi için marka boyut ve fiyat değerlerini giriniz");
                    String marka=s.nextLine();
                    String boyut=s.nextLine();
                    s.nextInt();
                    int fiyat=s.nextInt();
                    tv=new Televizyon(marka,boyut,fiyat);
                    System.out.println(tv); 
                    break;
                case 2:
                    if(tv!= null)
                    tv.getAc();
                    else System.out.println("tv yi olusturunuz");
                    break;
                case 3:
                    if(tv!=null)
                    tv.Kapa();
                      else System.out.println("tv yi olusturunuz");
                    break;
                case 4:
                    if(tv!=null){
                    System.out.println("sesi ne kadar arttıracaksınız");
                    int parametre=s.nextInt();
                        if(parametre!=1)
                        tv.sesArttır(parametre);
                        else
                        tv.sesArttır();
                        }
                    else System.out.println("tv yi olusturunuz");
                     break;
                case 5:
                    if(tv!= null){
                    System.out.println("sesi ne kadar azaltacaksınız");
                     int a=s.nextInt();
                        if(a!=1)
                        tv.sesAzalt(a);
                       else
                       tv.sesAzalt(); 
                       }
                    else System.out.println("tv yi olusturunuz");
                     break;
                default:
            }
        }
    }
    private static void menuGoster(){
        System.out.println("***********menu**************");
        System.out.println("0 çıkış\n"+
                "1  televizyon oluştur\n"+
                "2  televizyonu aç\n"+
                "3 televizyonu kapa\n"+
                "4 sesi arttır\n"+
                "5 sesi azalt\n");                
    }
}
class TeknolojikAlet{
    private String marka;
    private String boyut;
    private boolean acik;
    private int ses;
    
    public TeknolojikAlet(String marka, String boyut){
     this.boyut=boyut;
     this.marka=marka; 
     acik=false;
     ses=10;
     Ac();
    }
    public void setMarka(String marka){
    this.marka=marka;
    }
    public void setBoyut( String boyut){
    this.boyut=boyut;
    }
    public String getMarka(){
    return marka;
    }
    public String getBoyut(){
    return boyut;
    }
    public int getSes(){
    return ses;
    }
    public void setSes(int ses){
       this.ses=ses;
    }
    public void setAcik(boolean acik){
    this.acik=acik;
    }
    public boolean getAcik(){
    return acik;
    }
    public String toString(){
    return "marka "+getMarka()+" boyut "+getBoyut();
    }
    private void Ac(){
    if(acik==false){
        acik=true;
         System.out.println("alet açıldı");
                   }
    else
            System.out.println("alet zaten açık");
    }
    public void Kapa(){
    if(acik==true){
        acik=false;
         System.out.println("alet kapatıldı");
                   }
    else
            System.out.println("alet zaten kapalı");
    }
    public void sesArttır(){
        if(ses<20 && acik==true){
            ses++;
         System.out.println("ses seviyesi "+ses);
        }
        else 
            System.out.println("ses maksimum arttırılamaz veya alet kapalı");
    } 
    public void sesArttır(int arttırılacak){
        if(ses<20 && acik==true &&(ses+arttırılacak)<20){
            ses+=arttırılacak;
         System.out.println("ses seviyesi "+ses);
        }
        else 
            System.out.println("ses maksimum arttırılamaz veya alet kapalı");
    } 
    public void sesAzalt(){
        if(ses>0 && acik==true){
            ses--;
        System.out.println("ses seviyesi "+ses);
        }
        else 
            System.out.println("ses minimum azaltılamaz veya alet kapalı");
    }
    public void sesAzalt(int azaltılacak){
        if(ses>0 && acik==true && (ses-azaltılacak)>0){
            ses-=azaltılacak;
        System.out.println("ses seviyesi "+ses);
        }
        else 
            System.out.println("ses minimum azaltılamaz veya alet kapalı");
    }
    public void getAc(){
    Ac();
    }
}
class Televizyon extends TeknolojikAlet{
int fiyat;
public Televizyon(String marka, String boyut,int fiyat){
super(marka,boyut);
this.fiyat=fiyat;
}
  public void sesAzalt(int azaltılacak){
        if(getSes()>0 && getAcik()==true && (getSes()-azaltılacak)>0){
            setSes(getSes()-azaltılacak);
        System.out.println("ses seviyesi "+getSes());
        }
        else 
            System.out.println("ses minimum azaltılamaz veya tv kapalı");
    }
  
 public String toString(){
    return "marka "+getMarka()+" boyut "+getBoyut()+" fiyat "+fiyat;
    }
}
