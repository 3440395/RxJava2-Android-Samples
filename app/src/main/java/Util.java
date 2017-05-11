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

public class Util {


    public static void main(String[] args) throws IOException {
        List<User> users = new ArrayList<>();
        User user;
        jxl.Workbook readwb = null;
        InputStream instream = null;

        try {
            instream = new FileInputStream("C:/Users/Administrator/Desktop/123.xls");
            readwb = Workbook.getWorkbook(instream);
            Sheet readsheet = readwb.getSheet(0);
            //获取Sheet表中所包含的总列数
            int rsColumns = readsheet.getColumns();
            //获取Sheet表中所包含的总行数
            int rsRows = readsheet.getRows();
            //获取指定单元格的对象引用
            for (int i = 1; i < rsRows; i++) {
                user = new User();
                user.index = readsheet.getCell(0, i).getContents();
                int fenshui = 0;
                for (int j = 6; j < user.fenshu.length + 6; j++) {
                    Cell cell = readsheet.getCell(j, i);
                    user.fenshu[fenshui] = cell.getContents();
                    fenshui++;
                }
                users.add(user);
            }

            for (User user1 : users) {
                jisuanE(user1);
                jisuanP(user1);
                jisuanN(user1);
                jisuanL(user1);

                System.out.print("编号：" + user1.index + "  E：" + user1.E + "  P:" + user1.P + "  N:" + user1.N + "  L:" + user1.L);
                System.out.println();
            }
//            //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄
//
//            jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(
//
//                    "F:/红楼人物1.xls"), readwb);
//
//            //读取第一张工作表
//
//            jxl.write.WritableSheet ws = wwb.getSheet(0);
//
//            //获得第一个单元格对象
//
//            jxl.write.WritableCell wc = ws.getWritableCell(0, 0);
//
//            //判断单元格的类型, 做出相应的转化
//
//            if (wc.getType() == CellType.LABEL)
//
//            {
//
//                Label l = (Label) wc;
//
//                l.setString("新姓名");
//
//            }
//
//            //写入Excel对象
//
//            wwb.write();
//
//            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instream.close();
            readwb.close();

        }

    }

    private static void jisuanE(User user) {
        String[] fenshu = user.fenshu;
        int sum = 0;
        //暂时存数据
        int[] f = new int[19];
        f[0] = Integer.parseInt(fenshu[2 - 1]);
        f[1] = Integer.parseInt(fenshu[3 - 1]);
        f[2] = Integer.parseInt(fenshu[4 - 1]);
        f[3] = Integer.parseInt(fenshu[5 - 1]);
        f[4] = Integer.parseInt(fenshu[6 - 1]);
        f[5] = Integer.parseInt(fenshu[11 - 1]);
        f[6] = Integer.parseInt(fenshu[12 - 1]);
        f[7] = Integer.parseInt(fenshu[14 - 1]);
        f[8] = Integer.parseInt(fenshu[16 - 1]);
        f[9] = Integer.parseInt(fenshu[24 - 1]);
        f[10] = Integer.parseInt(fenshu[30 - 1]);
        f[11] = Integer.parseInt(fenshu[37 - 1]);
        f[12] = Integer.parseInt(fenshu[38 - 1]);
        f[13] = Integer.parseInt(fenshu[49 - 1]);
        f[14] = Integer.parseInt(fenshu[68 - 1]);
        f[15] = Integer.parseInt(fenshu[71 - 1]);
        f[16] = Integer.parseInt(fenshu[74 - 1]);
        f[17] = Integer.parseInt(fenshu[76 - 1]);
        f[18] = Integer.parseInt(fenshu[79 - 1]);
        for (int i : f) {
            if (i == 1) {
                sum += 1;
            } else if (i == 2) {
                sum += 0;
            }
        }
        int[] f1 = new int[2];
        f1[0] = Integer.parseInt(fenshu[32 - 1]);
        f1[1] = Integer.parseInt(fenshu[52 - 1]);
        for (int i : f1) {
            if (i == 1) {
                sum += 0;
            } else if (i == 2) {
                sum += 1;
            }
        }

        user.E = sum;
    }

    private static void jisuanP(User user) {
        String[] fenshu = user.fenshu;
        int sum = 0;
        //暂时存数据
        int[] f = new int[12];
        f[0] = Integer.parseInt(fenshu[7 - 1]);
        f[1] = Integer.parseInt(fenshu[17 - 1]);
        f[2] = Integer.parseInt(fenshu[28 - 1]);
        f[3] = Integer.parseInt(fenshu[35 - 1]);
        f[4] = Integer.parseInt(fenshu[36 - 1]);
        f[5] = Integer.parseInt(fenshu[39 - 1]);
        f[6] = Integer.parseInt(fenshu[41 - 1]);
        f[7] = Integer.parseInt(fenshu[45 - 1]);
        f[8] = Integer.parseInt(fenshu[57 - 1]);
        f[9] = Integer.parseInt(fenshu[63 - 1]);
        f[10] = Integer.parseInt(fenshu[73 - 1]);
        f[11] = Integer.parseInt(fenshu[77 - 1]);
        for (int i : f) {
            if (i == 1) {
                sum += 1;
            } else if (i == 2) {
                sum += 0;
            }
        }
        int[] f1 = new int[8];
        f1[0] = Integer.parseInt(fenshu[23 - 1]);
        f1[1] = Integer.parseInt(fenshu[26 - 1]);
        f1[2] = Integer.parseInt(fenshu[29 - 1]);
        f1[3] = Integer.parseInt(fenshu[46 - 1]);
        f1[4] = Integer.parseInt(fenshu[51 - 1]);
        f1[5] = Integer.parseInt(fenshu[53 - 1]);
        f1[6] = Integer.parseInt(fenshu[65 - 1]);
        f1[7] = Integer.parseInt(fenshu[66 - 1]);
        for (int i : f1) {
            if (i == 1) {
                sum += 0;
            } else if (i == 2) {
                sum += 1;
            }
        }

        user.P = sum;
    }

    private static void jisuanN(User user) {
        String[] fenshu = user.fenshu;
        int sum = 0;
        //暂时存数据
        int[] f = new int[23];
        f[0] = Integer.parseInt(fenshu[1 - 1]);
        f[1] = Integer.parseInt(fenshu[8 - 1]);
        f[2] = Integer.parseInt(fenshu[9 - 1]);
        f[3] = Integer.parseInt(fenshu[13 - 1]);
        f[4] = Integer.parseInt(fenshu[15 - 1]);
        f[5] = Integer.parseInt(fenshu[19 - 1]);
        f[6] = Integer.parseInt(fenshu[20 - 1]);
        f[7] = Integer.parseInt(fenshu[25 - 1]);
        f[8] = Integer.parseInt(fenshu[27 - 1]);
        f[9] = Integer.parseInt(fenshu[34 - 1]);
        f[10] = Integer.parseInt(fenshu[44 - 1]);
        f[11] = Integer.parseInt(fenshu[47 - 1]);
        f[12] = Integer.parseInt(fenshu[48 - 1]);
        f[13] = Integer.parseInt(fenshu[55 - 1]);
        f[14] = Integer.parseInt(fenshu[58 - 1]);
        f[15] = Integer.parseInt(fenshu[59 - 1]);
        f[16] = Integer.parseInt(fenshu[60 - 1]);
        f[17] = Integer.parseInt(fenshu[61 - 1]);
        f[18] = Integer.parseInt(fenshu[62 - 1]);
        f[19] = Integer.parseInt(fenshu[67 - 1]);
        f[20] = Integer.parseInt(fenshu[72 - 1]);
        f[21] = Integer.parseInt(fenshu[78 - 1]);
        f[22] = Integer.parseInt(fenshu[82 - 1]);
        for (int i : f) {
            if (i == 1) {
                sum += 1;
            } else if (i == 2) {
                sum += 0;
            }
        }
        user.N = sum;
    }

    private static void jisuanL(User user) {
        String[] fenshu = user.fenshu;
        int sum = 0;
        //暂时存数据
        int[] f = new int[13];
        f[0] = Integer.parseInt(fenshu[10 - 1]);
        f[1] = Integer.parseInt(fenshu[18 - 1]);
        f[2] = Integer.parseInt(fenshu[21 - 1]);
        f[3] = Integer.parseInt(fenshu[22 - 1]);
        f[4] = Integer.parseInt(fenshu[33 - 1]);
        f[5] = Integer.parseInt(fenshu[40 - 1]);
        f[6] = Integer.parseInt(fenshu[42 - 1]);
        f[7] = Integer.parseInt(fenshu[43 - 1]);
        f[8] = Integer.parseInt(fenshu[50 - 1]);
        f[9] = Integer.parseInt(fenshu[64 - 1]);
        f[10] = Integer.parseInt(fenshu[81 - 1]);
        f[11] = Integer.parseInt(fenshu[83 - 1]);
        f[12] = Integer.parseInt(fenshu[84 - 1]);
        for (int i : f) {
            if (i == 1) {
                sum += 1;
            } else if (i == 2) {
                sum += 0;
            }
        }
        int[] f1 = new int[6];
        f1[0] = Integer.parseInt(fenshu[31 - 1]);
        f1[1] = Integer.parseInt(fenshu[54 - 1]);
        f1[2] = Integer.parseInt(fenshu[56 - 1]);
        f1[3] = Integer.parseInt(fenshu[70 - 1]);
        f1[4] = Integer.parseInt(fenshu[75 - 1]);
        f1[5] = Integer.parseInt(fenshu[80 - 1]);
        for (int i : f1) {
            if (i == 1) {
                sum += 0;
            } else if (i == 2) {
                sum += 1;
            }
        }

        user.L = sum;
    }

}





























































