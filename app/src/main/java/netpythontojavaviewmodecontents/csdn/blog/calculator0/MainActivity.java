package netpythontojavaviewmodecontents.csdn.blog.calculator0;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import android.view.View.OnClickListener;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button add;     //按钮+
    private Button subtract;    //按钮-
    private Button multiply;    //按钮*
    private Button divide;      //按钮/
    private Button equal;       //按钮=
    private Button delete;      //按钮删除一个输入的符号
    private Button clear;       //按钮用来清除输入框
    private Button point;       //按钮小数点

    private Button one;         //按钮1
    private Button two;
    private Button three;

    private Button four;
    private Button five;
    private Button six;

    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;

    private EditText showtext;//用来显示输入的符号和数字

    private String OperateSum="";//字符串用来保存输入的数字和符号
    private char Operator;      //用来记录运算符号
    private double num1=0,num2=0,sum=0;     //num1,num2记录输入的数字，sum保存运算的结果
    //private boolean NewCalculate=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//对按钮和事件进行初始化
    }
    private void initView()
    {
        one=(Button) findViewById(R.id.one);
        two=(Button) findViewById(R.id.two);
        three=(Button) findViewById(R.id.three);
        four=(Button) findViewById(R.id.four);
        five=(Button) findViewById(R.id.five);
        six=(Button) findViewById(R.id.six);
        seven=(Button) findViewById(R.id.seven);
        eight=(Button) findViewById(R.id.eight);
        nine=(Button) findViewById(R.id.nine);
        zero=(Button) findViewById(R.id.zero);

        add=(Button) findViewById(R.id.add);
        subtract=(Button) findViewById(R.id.subtract);
        multiply=(Button) findViewById(R.id.multiply);
        divide=(Button) findViewById(R.id.divide);
        delete=(Button) findViewById(R.id.delete);
        clear=(Button) findViewById(R.id.clear);
        equal=(Button) findViewById(R.id.equal);
        point=(Button) findViewById(R.id.point);
        //about=(Button) findViewById(R.id.about);
        showtext=(EditText) findViewById(R.id.text);
        showtext.setCursorVisible(false);

        zero.setOnClickListener(this);//添加按钮事件
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        clear.setOnClickListener(this);
        point.setOnClickListener(this);
        //about.setOnClickListener(this);
        showtext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:      //记录输入的数字1
                OperateSum=AddSum('1');//把数字添加进OperateSum
                showtext.setText(OperateSum);   //把输入的数字显示在EditText
                break;
            case R.id.two:      //记录输入的数字2
                OperateSum=AddSum('2');
                showtext.setText(OperateSum);
                break;
            case R.id.three:
                OperateSum=AddSum('3');
                showtext.setText(OperateSum);
                break;
            case R.id.four:
                OperateSum=AddSum('4');
                showtext.setText(OperateSum);
                break;
            case R.id.five:
                OperateSum=AddSum('5');
                showtext.setText(OperateSum);
                break;
            case R.id.six:
                OperateSum=AddSum('6');
                showtext.setText(OperateSum);
                break;
            case R.id.seven:
                OperateSum=AddSum('7');
                showtext.setText(OperateSum);
                break;
            case R.id.eight:
                OperateSum=AddSum('8');
                showtext.setText(OperateSum);
                break;
            case R.id.nine:
                OperateSum=AddSum('9');
                showtext.setText(OperateSum);
                break;
            case R.id.zero:
                OperateSum=AddSum('0');
                showtext.setText(OperateSum);
                break;

            case R.id.add:      //记录+号
                OperateSum=AddSum('+');
                Operator='+';       //记录加法
                showtext.setText(OperateSum);   //把输入的+号显示在EditText
                break;
            case R.id.subtract:
                OperateSum=AddSum('-');
                Operator='-';
                showtext.setText(OperateSum);
                break;
            case R.id.multiply:
                OperateSum=AddSum('*');
                Operator='*';
                showtext.setText(OperateSum);
                break;
            case R.id.divide:
                OperateSum=AddSum('/');
                Operator='/';
                showtext.setText(OperateSum);
                break;
            case R.id.point:
                OperateSum=AddSum('.');
                showtext.setText(OperateSum);
                break;
            case R.id.delete:       //删除刚刚输入的一个符号
                if(OperateSum.length()>=1)//当至少已经输入了一个符号才执行
                {
                    OperateSum=OperateSum.substring(0,OperateSum.length()-1);
                }
                showtext.setText(OperateSum);
                break;
            case R.id.clear:        //清除整个显示框
                OperateSum="";      //变量全部初始化
                num1=0;
                num2=0;
                sum=0;
                Operator=' ';
                showtext.setText(OperateSum);
                break;
            case R.id.equal:
                if(CheckInput(OperateSum))//当输入的数字和运算符都正确，才进行计算
                {
                    OperateSum=OperateSum+"="+String.valueOf(equals(OperateSum));
                    showtext.setText(OperateSum);//显示数字运算符和结果
                    OperateSum=String.valueOf(sum); //保存运算结果，以便再直接输入一个运算符和一个数字进行下一次运算
                }
                else                        //输入不合理弹出警告
                {
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;

        }
    }
    public String AddSum(char c)//添加并记录一个输入的数字或符号
    {
        OperateSum=OperateSum+String.valueOf(c);
        return OperateSum;
    }

    public boolean CheckInput(String OperateSum)    //这个方法用来检查用户输入的数字是否合理，比如用户输入了"9/3"这是合理的，加入输入了 " 8/*",这部合理
    {
        if(OperateSum.length()<=2)//至少要分别输入了一个数字和一个运算符和一个数字，输入长度<=2肯定不合理，如输入 99 按下=按钮肯定不计算
        {
            return false;
        }
        if(OperateSum.indexOf(Operator, 1)==-1)     //如果没有输入运算符，肯定不合理
        {
            return false;
        }

        if(OperateSum.endsWith(String.valueOf(Operator)))       //最后以运算符结尾而不是数字，肯定不合理 如输入 9** ，不进行计算
        {
            return false;
        }
        return true;
    }
    public double equals(String OperateSum)         //计算结果
    {
        int indexOfOperator=0;
        indexOfOperator=OperateSum.indexOf(Operator,1);         //计算运算符在从输入的OperateSum字符串里的位置
        if(OperateSum.length()>=3)
        {
            num1=Double.parseDouble(OperateSum.substring(0, indexOfOperator));  //从输入的OperateSum字符串里得到第一个运算数
            num2=Double.parseDouble(OperateSum.substring(indexOfOperator + 1, OperateSum.length()));    //从输入的OperateSum字符串里得到第二个运算数
        }
        switch (Operator)       //根据运算符进行计算
        {
            case '+':           //加法运算
                sum=num1+num2;
                break;
            case '-':           //减法运算
                sum=num1-num2;
                break;
            case '*':           //乘法运算
                sum=num1*num2;
                break;
            case '/':           //除法运算
                if(num2!=0)     //除数不应该为0
                {
                    sum=num1/num2;
                }
                else
                {
                    sum=0;
                    Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();//若除数是0，弹出警告
                }
                break;
            default:
                break;
        }
        return sum;         //返回结果
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
