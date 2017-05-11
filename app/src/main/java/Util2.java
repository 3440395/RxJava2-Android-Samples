import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * Created by xuekai on 2017/5/11.
 */

public class Util2 {


    public static void main(String[] args) throws IOException {
        List<User2> users = new ArrayList<>();
        User2 user;
        Workbook readwb = null;
        InputStream instream = null;

        try {
            instream = new FileInputStream("C:/Users/Administrator/Desktop/234.xls");
            readwb = Workbook.getWorkbook(instream);
            Sheet readsheet = readwb.getSheet(1);
            //获取Sheet表中所包含的总列数
            int rsColumns = readsheet.getColumns();
            //获取Sheet表中所包含的总行数
            int rsRows = readsheet.getRows();
            //获取指定单元格的对象引用
            for (int i = 1; i < rsRows; i++) {
                user = new User2();
                user.index = readsheet.getCell(0, i).getContents();
                int fenshui = 0;
                for (int j = 1; j < rsColumns; j++) {
                    Cell cell = readsheet.getCell(j, i);
                    user.fenshu[fenshui] = cell.getContents();
                    fenshui++;
                }
                users.add(user);
            }

            for (User2 user1 : users) {
                jisuanCg(user1);
                jisuanGl(user1);
                jisuanSh(user1);
                jisuanXs(user1);
                jisuanYj(user1);
                jisuanYs(user1);
                System.out.print("编号："+user1.index + "  常规："+user1.cg+"  现实:"+user1.xs+"  研究:"+user1.yj+"  管理:"+user1.gl+"  社会:"+user1.sh+"  艺术:"+user1.ys);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instream.close();
            readwb.close();

        }

    }

    private static void jisuanCg(User2 user) {
        String[] fenshu = user.fenshu;
        int sum=0;
        //暂时存数据
        int[] f=new int[7];
        f[0] = Integer.parseInt(fenshu[7-1]);
        f[1]= Integer.parseInt(fenshu[19-1]);
        f[2]= Integer.parseInt(fenshu[29-1]);
        f[3]= Integer.parseInt(fenshu[39-1]);
        f[4]= Integer.parseInt(fenshu[41-1]);
        f[5]= Integer.parseInt(fenshu[51-1]);
        f[6]= Integer.parseInt(fenshu[57-1]);

        for (int i : f) {
            if (i==1) {
                sum+=1;
            }else if(i==2){
                sum+=0;
            }
        }
        int[] f1=new int[2];
        f[0]= Integer.parseInt(fenshu[5-1]);
        f[1]= Integer.parseInt(fenshu[18-1]);
        f[2]= Integer.parseInt(fenshu[40-1]);
        for (int i : f1) {
            if (i==1) {
                sum+=0;
            }else if(i==2){
                sum+=1;
            }
        }

        user.cg=sum;
    }
    private static void jisuanXs(User2 user) {
        String[] fenshu = user.fenshu;
        int sum=0;
        //暂时存数据
        int[] f=new int[5];
        f[0] = Integer.parseInt(fenshu[2-1]);
        f[1]= Integer.parseInt(fenshu[13-1]);
        f[2]= Integer.parseInt(fenshu[22-1]);
        f[3]= Integer.parseInt(fenshu[36-1]);
        f[4]= Integer.parseInt(fenshu[43-1]);
        for (int i : f) {
            if (i==1) {
                sum+=1;
            }else if(i==2){
                sum+=0;
            }
        }
        int[] f1=new int[5];
        f1[0] = Integer.parseInt(fenshu[14-1]);
        f1[1]= Integer.parseInt(fenshu[23-1]);
        f1[2]= Integer.parseInt(fenshu[44-1]);
        f1[3]= Integer.parseInt(fenshu[47-1]);
        f1[4]= Integer.parseInt(fenshu[48-1]);
        for (int i : f1) {
            if (i==1) {
                sum+=0;
            }else if(i==2){
                sum+=1;
            }
        }

        user.xs=sum;
    }
    private static void jisuanYj(User2 user) {
        String[] fenshu = user.fenshu;
        int sum=0;
        //暂时存数据
        int[] f=new int[23];
        f[0] = Integer.parseInt(fenshu[6-1]);
        f[1]= Integer.parseInt(fenshu[8-1]);
        f[2]= Integer.parseInt(fenshu[20-1]);
        f[3]= Integer.parseInt(fenshu[30-1]);
        f[4]= Integer.parseInt(fenshu[31-1]);
        f[5]= Integer.parseInt(fenshu[42-1]);
        for (int i : f) {
            if (i==1) {
                sum+=1;
            }else if(i==2){
                sum+=0;
            }
        }
        int[] f1=new int[4];
        f[0]= Integer.parseInt(fenshu[21-1]);
        f[1]= Integer.parseInt(fenshu[55-1]);
        f[2]= Integer.parseInt(fenshu[56-1]);
        f[3]= Integer.parseInt(fenshu[58-1]);
        for (int i : f1) {
            if (i==1) {
                sum+=0;
            }else if(i==2){
                sum+=1;
            }
        }

        user.yj=sum;
    }
    private static void jisuanGl(User2 user) {
        String[] fenshu = user.fenshu;
        int sum=0;
        //暂时存数据
        int[] f=new int[7];
        f[0] = Integer.parseInt(fenshu[11-1]);
        f[1]= Integer.parseInt(fenshu[24-1]);
        f[2]= Integer.parseInt(fenshu[28-1]);
        f[3]= Integer.parseInt(fenshu[35-1]);
        f[4]= Integer.parseInt(fenshu[38-1]);
        f[5]= Integer.parseInt(fenshu[46-1]);
        f[6]= Integer.parseInt(fenshu[60-1]);
        for (int i : f) {
            if (i==1) {
                sum+=1;
            }else if(i==2){
                sum+=0;
            }
        }
        int[] f1=new int[3];
        f1[0] = Integer.parseInt(fenshu[3-1]);
        f1[1]= Integer.parseInt(fenshu[16-1]);
        f1[2]= Integer.parseInt(fenshu[25-1]);
        for (int i : f1) {
            if (i==1) {
                sum+=0;
            }else if(i==2){
                sum+=1;
            }
        }

        user.gl=sum;
    }
    private static void jisuanSh(User2 user) {
        String[] fenshu = user.fenshu;
        int sum=0;
        //暂时存数据
        int[] f=new int[4];
        f[0] = Integer.parseInt(fenshu[26-1]);
        f[1]= Integer.parseInt(fenshu[37-1]);
        f[2]= Integer.parseInt(fenshu[52-1]);
        f[3]= Integer.parseInt(fenshu[59-1]);
        for (int i : f) {
            if (i==1) {
                sum+=1;
            }else if(i==2){
                sum+=0;
            }
        }
        int[] f1=new int[6];
        f1[0] = Integer.parseInt(fenshu[1-1]);
        f1[1]= Integer.parseInt(fenshu[12-1]);
        f1[2]= Integer.parseInt(fenshu[15-1]);
        f1[3]= Integer.parseInt(fenshu[27-1]);
        f1[4]= Integer.parseInt(fenshu[45-1]);
        f1[5]= Integer.parseInt(fenshu[53-1]);
        for (int i : f1) {
            if (i==1) {
                sum+=0;
            }else if(i==2){
                sum+=1;
            }
        }

        user.sh=sum;
    }
    private static void jisuanYs(User2 user) {
        String[] fenshu = user.fenshu;
        int sum=0;
        //暂时存数据
        int[] f=new int[9];
        f[0] = Integer.parseInt(fenshu[4-1]);
        f[1]= Integer.parseInt(fenshu[9-1]);
        f[2]= Integer.parseInt(fenshu[10-1]);
        f[3]= Integer.parseInt(fenshu[17-1]);
        f[4]= Integer.parseInt(fenshu[33-1]);
        f[5]= Integer.parseInt(fenshu[34-1]);
        f[6]= Integer.parseInt(fenshu[49-1]);
        f[7]= Integer.parseInt(fenshu[50-1]);
        f[8]= Integer.parseInt(fenshu[54-1]);
        for (int i : f) {
            if (i==1) {
                sum+=1;
            }else if(i==2){
                sum+=0;
            }
        }
        int[] f1=new int[1];
        f1[0] = Integer.parseInt(fenshu[32-1]);
        for (int i : f1) {
            if (i==1) {
                sum+=0;
            }else if(i==2){
                sum+=1;
            }
        }

        user.ys=sum;
    }

}





























































