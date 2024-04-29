
0701

[Fibonacci数列_牛客题霸_牛客网 (nowcoder.com)](https://www.nowcoder.com/practice/18ecd0ecf5ef4fe9ba3f17f8d00d2d66?tpId=85&&tqId=29846&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking)

```javascript
public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别

        int a = 0;

        int b = 1;

        int c = 1;

        Scanner scanner = new Scanner (System.in);

        int input = in.nextInt ();

  

        while (input > b) {

            c = a + b;

            a = b;

            b = c;

        }

  

        int out=(b-input)<(input-a)?(b-input):(input-a);

        System.out.println (out);

    }
```

0702

