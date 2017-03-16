import java.util.*;
public class ClcArea{
    private static final double EARTH_RADIUS = 6378.137;
    private static double rad(double d){
       return d * Math.PI / 180.0;
    }    
    public static double GetDistance(double lng1, double lat1, double lng2, double lat2) {
       double radLat1 = rad(lat1);
       double radLat2 = rad(lat2);
       double a = radLat1 - radLat2;
       double b = rad(lng1) - rad(lng2);
       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
       s = s * EARTH_RADIUS;
      // s = Math.round(s * 10000) / 10000;
       return s;
    }

    private static double gps2d(double lat_a, double lng_a, double lat_b, double lng_b){
        double d = 0;
        lat_a=lat_a*Math.PI/180;
        lng_a=lng_a*Math.PI/180;
        lat_b=lat_b*Math.PI/180;
        lng_b=lng_b*Math.PI/180;
                
        d=Math.sin(lat_a)*Math.sin(lat_b)+Math.cos(lat_a)*Math.cos(lat_b)*Math.cos(lng_b-lng_a);
        d=Math.sqrt(1-d*d);
        d=Math.cos(lat_b)*Math.sin(lng_b-lng_a)/d;
        d=Math.asin(d)*180/Math.PI;
        //d = Math.round(d*10000);
        return d;
    }


    public static double[] MillierConvertion(double lat, double lon)  
    {  
         double L = 6381372 * Math.PI * 2;
         double W=L;
         double H=L/2;
         double mill=2.3;
         double x = lon * Math.PI / 180;
         double y = lat * Math.PI / 180;
         y=1.25 * Math.log( Math.tan( 0.25 * Math.PI + 0.4 * y ) );
         x = ( W / 2 ) + ( W / (2 * Math.PI) ) * x;  
         y = ( H / 2 ) - ( H / ( 2 * mill ) ) * y;  
         double[] result=new double[2];  
         result[0]=x;  
         result[1]=y;  
         return result;  
    }  
     /** 
     * 求B点经纬度 
     * @param A 已知点的经纬度， 
     * @param distance   AB两地的距离  单位km 
     * @param angle  AB连线与正北方向的夹角（0~360） 
     * @return  B点的经纬度 
     */  
    public static MyLatLng getMyLatLng(MyLatLng A,double distance,double angle){  
          
        double dx = distance*1000*Math.sin(Math.toRadians(angle));  
        double dy= distance*1000*Math.cos(Math.toRadians(angle));  
          
        double bjd=(dx/A.Ed+A.m_RadLo)*180./Math.PI;  
        double bwd=(dy/A.Ec+A.m_RadLa)*180./Math.PI;  
        return new MyLatLng(bjd, bwd);  
    }  
      
    /** 
     * 获取AB连线与正北方向的角度 
     * @param A  A点的经纬度 
     * @param B  B点的经纬度 
     * @return  AB连线与正北方向的角度（0~360） 
     */  
    public  static double getAngle(MyLatLng A,MyLatLng B){  
        double dx=(B.m_RadLo-A.m_RadLo)*A.Ed;  
        double dy=(B.m_RadLa-A.m_RadLa)*A.Ec;  
        double angle=0.0;  
        angle=Math.atan(Math.abs(dx/dy))*180./Math.PI;    
        double dLo=B.m_Longitude-A.m_Longitude;  
        double dLa=B.m_Latitude-A.m_Latitude;  
        if(dLo>0&&dLa<=0){  
            angle=(90.-angle)+90;  
        }  
        else if(dLo<=0&&dLa<0){  
            angle=angle+180.;  
        }else if(dLo<0&&dLa>=0){  
            angle= (90.-angle)+270;  
        }  
        return angle;  
    }  
    static class MyLatLng {  
        final static double Rc=6378137;  
        final static double Rj=6356725;  
        double m_LoDeg,m_LoMin,m_LoSec;  
        double m_LaDeg,m_LaMin,m_LaSec;  
        double m_Longitude,m_Latitude;  
        double m_RadLo,m_RadLa;  
        double Ec;  
        double Ed;  
        public MyLatLng(double longitude,double latitude){  
            m_LoDeg=(int)longitude;  
            m_LoMin=(int)((longitude-m_LoDeg)*60);  
            m_LoSec=(longitude-m_LoDeg-m_LoMin/60.)*3600;  
              
            m_LaDeg=(int)latitude;  
            m_LaMin=(int)((latitude-m_LaDeg)*60);  
            m_LaSec=(latitude-m_LaDeg-m_LaMin/60.)*3600;  
              
            m_Longitude=longitude;  
            m_Latitude=latitude;  
            m_RadLo=longitude*Math.PI/180.;  
            m_RadLa=latitude*Math.PI/180.;  
            Ec=Rj+(Rc-Rj)*(90.-m_Latitude)/90.;  
            Ed=Ec*Math.cos(m_RadLa);  
        }  
    }  


    static class LatLng{

        public double lat;
        public double lng;

        public LatLng(double lat,double lng){
            this.lat = lat;
            this.lng = lng;
        }
    }

    public static void main(String[] args) {
        //System.out.println(gps2d(39.951469, 116.34468, 39.950439, 116.344879));
        //System.out.println(GetDistance(116.34468, 39.951469, 116.344879,39.950439));
        // 39.951469 116.34468      A
        // 39.950439 116.344879     B
        // 39.950538 116.346443     C
        // 39.951148 116.346359     D
        // 39.951107 116.345481     E
        // 39.951591 116.345405     F

    
        // LatLng A = new LatLng(39.951469,116.34468);
        // LatLng B = new LatLng(39.950439,116.344879);
        // LatLng C = new LatLng(39.950538,116.346443);
        // LatLng D = new LatLng(39.951148,116.346359);
        // LatLng E = new LatLng(39.951107,116.345481);
        // LatLng F = new LatLng(39.951591,116.345405);


        // 39.952552 116.344047
        // 39.951904 116.344238
        // 39.952205 116.345855
        // 39.95285 116.34568
        LatLng A = new LatLng(39.952552,116.344047);
        LatLng B = new LatLng(39.951904,116.344238);
        LatLng C = new LatLng(39.952205,116.345855);
        LatLng D = new LatLng(39.95285,116.34568);

        List<LatLng> makers = new ArrayList<>();
        makers.add(A);
        makers.add(B);
        makers.add(C);
        makers.add(D);
        //makers.add(E);
        //makers.add(F);
        makers.add(A);

        double center_lat = 0.0;
        double center_lng = 0.0;
        for(int i=0;i<makers.size()-1;i++){
            center_lat += makers.get(i).lat;
            center_lng += makers.get(i).lng;
        }
        MyLatLng G=new MyLatLng(center_lng/(makers.size()-1),center_lat/(makers.size()-1)); 
        System.out.println(G.m_Longitude+" " + G.m_Latitude);
        double area_all = 0.0;

        for(int i=0;i<makers.size()-1;i++){
            
            double area = 0.0;

            MyLatLng before = new MyLatLng(makers.get(i).lng,makers.get(i).lat);  
            MyLatLng after = new MyLatLng(makers.get(i+1).lng,makers.get(i+1).lat); 
            double angle = getAngle(G, before)-getAngle(G, after);
            double gb = GetDistance(G.m_Longitude, G.m_Latitude, before.m_Longitude, before.m_Latitude)*1000;
            double ga = GetDistance(G.m_Longitude, G.m_Latitude, after.m_Longitude, after.m_Latitude)*1000;
            System.out.println("夹角a: "+ (getAngle(G, before)) + "   夹角a: "+ (getAngle(G, after)) + "   夹角: "+ (angle) + "   gb长度：" + gb + "  ga长度：" + ga);
            if(angle>=0 && angle<180){
                double sinvalue = Math.sin(angle*Math.PI/180);
                area = 0.5*gb*ga*sinvalue;
                System.out.println("面积(0~180): "+ area);
            }else if(angle==180 ||angle==-180){
                area = 0.0;
            }else if(angle>180 || angle<-180){
                double angle_re = 360-Math.abs(angle);
                double sinvalue = Math.sin(Math.abs(angle_re)*Math.PI/180);
                area = (0.5*gb*ga*sinvalue);
                System.out.println("面积(180~360): "+ area);
            }else{
                double sinvalue = Math.sin(Math.abs(angle)*Math.PI/180);
                area = -(0.5*gb*ga*sinvalue);
                System.out.println("面积(-180~0): "+ area);
            }
            area_all = area_all + area;
        }

        System.out.println("总面积为："+ area_all);

        //////////////////////////////////////////////////////
        ///////////////////测试案例///////////////////////////
        // MyLatLng A=new MyLatLng(116.344152,39.952521);  
        // MyLatLng B=new MyLatLng(116.344987,39.952390);  
        // System.out.println(getAngle(B,A));
        // MyLatLng C=new MyLatLng(116.344354,39.951921);   
        // MyLatLng D=new MyLatLng(116.344924,39.951985);  
        // System.out.println(getAngle(B,C));
        // //39.952521, 116.344152  A
        // //39.951921, 116.344354  C
        // //39.952390, 116.344987  B
        // //39.951985, 116.344924  D
        // System.out.println("BA与BC之间的夹角"+ (getAngle(B,A)-getAngle(B,C)));
        // //转换为米
        // double ba = GetDistance(116.344987, 39.952390, 116.344152, 39.952521)*1000;
        // double bc = GetDistance(116.344987, 39.952390, 116.344354, 39.951921)*1000;
        // System.out.println("BA的距离为："+ba + " BC的距离为："+ bc);

        // double sinvalue = Math.sin((getAngle(B,A)-getAngle(B,C))*Math.PI/180);
        // System.out.println("BA与BC之间的夹角sin："+ sinvalue);

        // double area = 0.5*ba*bc*sinvalue;
        // System.out.println("三角形面积为："+ area);
    }


}