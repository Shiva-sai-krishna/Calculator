package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    AppCompatButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,be,bb1,bb2,bdot;
    AppCompatButton bplus,bminus,bdiv,bmul,b1byx,broot,bx2,bxfact,bln,blog,bsin,bcos,btan;
    AppCompatButton bac,bc,beql;

    TextView tvmain,tvsec;

    String a,b;
    int bracketbuffer=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvmain=findViewById(R.id.tvmain);
        tvsec=findViewById(R.id.tvsec);

        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        bb1=findViewById(R.id.bb1);
        bb2=findViewById(R.id.bb2);
        be=findViewById(R.id.be);
        bdot=findViewById(R.id.bdot);

        bplus=findViewById(R.id.bplus);
        bminus=findViewById(R.id.bminus);
        bdiv=findViewById(R.id.bdiv);
        bmul=findViewById(R.id.bmul);
        b1byx=findViewById(R.id.b1byx);
        broot=findViewById(R.id.broot);
        bx2=findViewById(R.id.bsqr);
        bxfact=findViewById(R.id.bfact);
        bln=findViewById(R.id.bln);
        blog=findViewById(R.id.blog);
        bsin=findViewById(R.id.bsin);
        bcos=findViewById(R.id.bcos);
        btan=findViewById(R.id.btan);

        bac=findViewById(R.id.bac);
        bc=findViewById(R.id.bc);
        beql=findViewById(R.id.beql);
    }
    Boolean lastIsOperator(String a)
    {
        if (!isEmpty(a)) {
            char c = a.charAt(a.length() - 1);
            if (c == '+' || c == '-' || c == '×' || c == '/')
                return true;
        }
        return false;

    }

    Boolean lastIsNumber(String a)
    {
        if (!isEmpty(a)) {
            char c = a.charAt(a.length() - 1);
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
                return true;
        }
        return false;
    }

    Boolean lastIsSpecial(String a)
    {
        if (!isEmpty(a)) {
            char c = a.charAt(a.length() - 1);
            if (c == ')' || c == 'e')
                return true;
        }
        return false;
    }

    Boolean lastIsSpecial2(String a)
    {
        if (!isEmpty(a)) {
            char c = a.charAt(a.length() - 1);
            if (c == '!'|| c == '²')
                return true;
        }
        return false;
    }

    Boolean lastIsDot(String a)
    {
        if (!isEmpty(a)) {
            char c = a.charAt(a.length() - 1);
            if (c == '.')
                return true;
        }
        return false;
    }

    Boolean lastIsB1(String a)
    {
        if (!isEmpty(a)) {
            char c = a.charAt(a.length() - 1);
            if (c == '(')
                return true;
        }
        return false;
    }

    Boolean lastIsB2(String a)
    {
        if (!isEmpty(a)) {
            char c = a.charAt(a.length() - 1);
            if (c == ')')
                return true;
        }
        return false;
    }

    Boolean lastIsRoot(String a)
    {
        if (!isEmpty(a)) {
            char c = a.charAt(a.length() - 1);
            if (c == '√')
                return true;
        }
        return false;
    }

    Boolean isEmpty(String a)
    {
        if (a.equals(""))
            return true;
        return false;
    }

    public void numberClick(View view) {
        a=tvmain.getText().toString();
        switch (view.getId()) {
            case R.id.b1 :
                if (!a.equals("0") && !lastIsSpecial(a) && !lastIsSpecial2(a))
                    tvmain.setText(a+"1");
                break;
            case R.id.b2 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                tvmain.setText(a+"2");
                break;
            case R.id.b3 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                tvmain.setText(a+"3");
                break;
            case R.id.b4 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                tvmain.setText(a+"4");
                break;
            case R.id.b5 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                tvmain.setText(a+"5");
                break;
            case R.id.b6 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                tvmain.setText(a+"6");
                break;
            case R.id.b7 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                tvmain.setText(a+"7");
                break;
            case R.id.b8 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                tvmain.setText(a+"8");
                break;
            case R.id.b9 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                tvmain.setText(a+"9");
                break;
            case R.id.bb1 :
                if (lastIsOperator(a)||isEmpty(a)||lastIsB1(a)||lastIsRoot(a)) {
                    tvmain.setText(a + "(");
                    bracketbuffer++;
                }
                break;
            case R.id.bb2 :
                if (!lastIsOperator(a) && bracketbuffer!=0 && !lastIsDot(a)) {
                    tvmain.setText(a + ")");
                    bracketbuffer--;
                }
                break;
            case R.id.b0 :
                if (!a.equals("0") && !lastIsSpecial(a)&& !lastIsSpecial2(a))
                    tvmain.setText(a+"0");
                break;
            case R.id.be :
                if (lastIsOperator(a)||isEmpty(a)||lastIsB1(a)||lastIsRoot(a))
                    tvmain.setText(a+"e");
                break;
            case R.id.bdot:
                if (!a.contains(".") && !isEmpty(a) && lastIsNumber(a) )
                    tvmain.setText(a+".");
                break;
            case R.id.bac :
                bracketbuffer=0;
                a="";
                b="";
                tvmain.setText("");
                tvsec.setText("");
                break;
            case R.id.bc :
                if (!isEmpty(a)) {
                    if (lastIsB2(a)) bracketbuffer++;
                    tvmain.setText(a.substring(0, a.length() - 1));
                }
                break;
        }

    }

    public void evaluate(View view) {
        tvsec.setText(tvmain.getText().toString()+"=");
        try {
            tvmain.setText(EvaluateExpression.evaluate(tvmain.getText().toString()));
        } catch (Exception e) {
            tvmain.setText("Error :(");
        }
    }

    String replaceLast(String a,String x) {
        return a.substring(0,a.length()-1)+x;
    }

    public void operatorClick(View view) {
        a=tvmain.getText().toString();
        switch (view.getId()) {
            case R.id.bplus:
                if (lastIsOperator(a))
                    tvmain.setText(replaceLast(a,"+"));
                else if (lastIsNumber(a)||lastIsSpecial(a)||lastIsSpecial2(a)) {
                    a=a+"+";
                    tvmain.setText(a);
                }
                else {}
                break;
            case R.id.bminus:
                if (lastIsOperator(a))
                    tvmain.setText(replaceLast(a,"-"));
                else if (lastIsNumber(a)||lastIsSpecial(a)||lastIsSpecial2(a)||lastIsB1(a)||isEmpty(a)) {
                    a=a+"-";
                    tvmain.setText(a);
                }
                else {}
                break;
            case R.id.bmul:
                if (lastIsOperator(a))
                    tvmain.setText(replaceLast(a,"×"));
                else if (lastIsNumber(a)||lastIsSpecial(a)||lastIsSpecial2(a)) {
                    a=a+"×";
                    tvmain.setText(a);
                }
                else {}
                break;
            case R.id.bdiv:
                if (lastIsOperator(a))
                    tvmain.setText(replaceLast(a,"/"));
                else if (lastIsNumber(a)||lastIsSpecial(a)||lastIsSpecial2(a)) {
                    a=a+"/";
                    tvmain.setText(a);
                }
                else {}
                break;
            case R.id.bsin:
                if (lastIsOperator(a)||isEmpty(a)||lastIsB1(a)) {
                    a=a+"sin(";
                    tvmain.setText(a);
                    bracketbuffer++;
                }
                break;
            case R.id.bcos:
                if (lastIsOperator(a)||isEmpty(a)||lastIsB1(a)) {
                    a=a+"cos(";
                    tvmain.setText(a);
                    bracketbuffer++;
                }
                break;
            case R.id.btan:
                if (lastIsOperator(a)||isEmpty(a)||lastIsB1(a)) {
                    a=a+"tan(";
                    tvmain.setText(a);
                    bracketbuffer++;
                }
                break;
            case R.id.blog:
                if (lastIsOperator(a)||isEmpty(a)||lastIsB1(a)) {
                    a=a+"log(";
                    tvmain.setText(a);
                    bracketbuffer++;
                }
                break;
            case R.id.bln:
                if (lastIsOperator(a)||isEmpty(a)||lastIsB1(a)) {
                    a=a+"ln(";
                    tvmain.setText(a);
                    bracketbuffer++;
                }
                break;
            case R.id.bfact:
                if (lastIsNumber(a)|| lastIsSpecial(a)) {
                    a=a+"!";
                    tvmain.setText(a);
                }
                break;
            case R.id.bsqr:
                if (lastIsNumber(a)|| lastIsSpecial(a)) {
                    a=a+"²";
                    tvmain.setText(a);
                }
                break;
            case R.id.broot:
                if (isEmpty(a)|| lastIsOperator(a)||lastIsB1(a)) {
                    a=a+"√";
                    tvmain.setText(a);
                }
                break;
            case R.id.b1byx:
                if (!isEmpty(a) && !lastIsOperator(a) && bracketbuffer==0 && !lastIsRoot(a)) {
                    a="1/("+a+")";
                    tvmain.setText(a);
                }
                break;
        }
    }
}

class EvaluateExpression
{

    static String[] tokens;
    static HashMap<String,Integer> precedence=new HashMap<String,Integer>();
    static Stack<String> ops;
    static Stack<Double> vals;
    static String number;
    static int j;
    static Double a,b;
    static Integer temp;
    static Boolean isNeg;
    static Double round;

    static void hardcode() {
        precedence.put("+",2);
        precedence.put("-",2);
        precedence.put("×",4);
        precedence.put("/",4);
        precedence.put("s",8);
        precedence.put("c",8);
        precedence.put("t",8);
        precedence.put("l",8);
        precedence.put("L",8);
        precedence.put("!",5);
        precedence.put("√",6);
        precedence.put("²",7);
        precedence.put("(",8);
    }

    static boolean isNumber(String x) {
        if (x.equals("1") ||x.equals("2") ||x.equals("3") ||x.equals("4") ||x.equals("5") ||x.equals("6") ||x.equals("7") ||x.equals("8") ||x.equals("9") || x.equals("0"))
            return true;
        return false;
    }

    static double factGamma(double n) {
        return  Math.sqrt(Math.PI * (2*n+(1.0/3))) * Math.pow(n, n) * Math.exp(-n);
    }

    static double fact(double n) {
        return (n == 0) ? 1 : n * fact(n - 1);
    }

    static boolean isDot(String x) {
        if (x.equals("."))
            return true;
        return false;
    }

    static boolean isReal(Double n) {
        Integer i=n.intValue();
        return !n.equals(i.doubleValue());
    }

    static void applyOperator(String op) {
        switch (op) {
            case "+" :
                a=vals.pop();
                b=vals.pop();
                vals.push(a+b);
                break;
            case "-" :
                a=vals.pop();
                b=vals.pop();
                vals.push(b-a);
                break;
            case "×" :
                a=vals.pop();
                b=vals.pop();
                vals.push(a*b);
                break;
            case "/" :
                a=vals.pop();
                b=vals.pop();
                vals.push(b/a);
                break;
            case "s" :
                a=vals.pop();
                vals.push(Math.sin(Math.toRadians(a)));
                break;
            case "c" :
                a=vals.pop();
                vals.push(Math.cos(Math.toRadians(a)));
                break;
            case "t" :
                a=vals.pop();
                vals.push(Math.tan(Math.toRadians(a)));
                break;
            case "l" :
                a=vals.pop();
                vals.push(Math.log(a));
                break;
            case "L" :
                a=vals.pop();
                vals.push(Math.log10(a));
                break;
            case "(" :
                break;
            case "√" :
                vals.push(Math.sqrt(vals.pop()));
                break;
            case "²" :
                vals.push(Math.pow(vals.pop(),2));
                break;
            case "!" :
                a=vals.pop();
                if (isReal(a))
                    vals.push(factGamma(a));
                else
                    vals.push(fact(a));
                break;

            default :
        }
    }

    static boolean highPrecedence(String op) {
        return precedence.get(ops.peek())>=precedence.get(op);
    }

    static String evaluate(String exp)
    {
        isNeg=false;
        hardcode();
        exp="("+exp+")";
        exp=exp.replaceAll("\\(-","(0-");
        exp=exp.replaceAll("sin\\(","s");
        exp=exp.replaceAll("cos\\(","c");
        exp=exp.replaceAll("tan\\(","t");
        exp=exp.replaceAll("ln\\(","l");
        exp=exp.replaceAll("log\\(","L");
        exp=exp.replaceAll("e","2.718281828459045");
        tokens=exp.split("");
        ops=new Stack<>();
        vals=new Stack<>();

        for(int i=0;i<tokens.length;) {

            if (isNumber(tokens[i])) {
                j=i;
                while (i<tokens.length && (isNumber(tokens[i])||isDot(tokens[i])))
                    i++;
                vals.push(Double.valueOf(exp.substring(j,i)));
            }

            else if (tokens[i].equals(")")) {
                while (!precedence.get(ops.peek()).equals(8))
                    applyOperator(ops.pop());
                applyOperator(ops.pop());
                i++;
            }

            else if (precedence.get(tokens[i]).equals(8)) {
                ops.push(tokens[i]);
                i++;
            }

            else {
                while (!ops.empty() && highPrecedence(tokens[i]) && !precedence.get(ops.peek()).equals(8))
                    applyOperator(ops.pop());
                ops.push(tokens[i]);
                i++;
            }
        }

        while (!ops.empty())
            applyOperator(ops.pop());

        round = Double.valueOf(String.format("%.8f", vals.peek()));
        if (isReal(round)) {

            return round.toString();
        }
        else {
            temp=round.intValue();
            return temp.toString();
        }
    }

}