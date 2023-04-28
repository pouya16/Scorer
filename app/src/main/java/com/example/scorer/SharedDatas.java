package com.example.scorer;

import com.example.scorer.database.Chapters;
import com.example.scorer.database.Game;

public class SharedDatas {

    public static final int level = 19;
    public static final int chapters = 20;
    public static int e_val = 0;
    public static int r_val = 0 ;
    public static int chapter_number = 0 ;
    public static int s_val = 0;
    public static int t_val = 0;
    public static int z_val = 0;
    public static int back_val = 1;
    public static int total_score = 0;

    public static Game game = null;
    public static Chapters chapter = null;

    public static void insertGameData(Game game){
        total_score = game.getB_var();
        r_val = game.getR_var();
        s_val = game.getS_var();
        t_val = game.getT_var();
        z_val = game.getZ_var();
        back_val = game.getBack_var();
    }

    public static int calcTotalScore(int ln){
        total_score = total_score + ln;
        if(game!=null){
            game.setB_var(total_score);
            game.setScore(total_score);
        }
        return total_score;
    }

    public static int calculateLn(int n){
        int ln = (e_val * r_val) + ((n-1)*t_val);
        calcTotalScore(ln);
        return ln;
    }

    public static void perform_yes(int n){
        int ln = calculateLn(n);
        e_val = e_val + (ln * s_val);
        calcTotalScore(ln);
    }


    public static void perform_no(int n){
        int ln = calculateLn(n);
        e_val = e_val + (ln * z_val);
        calcTotalScore(ln);
    }

}
