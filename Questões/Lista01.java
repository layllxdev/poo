import java.util.Scanner;

public class Lista01 {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Questão: ");
    int q = sc.nextInt();

    switch (q) {
      case 1 -> questao1();
      case 2 -> questao2();
      case 3 -> questao3();
      case 4 -> questao4();
      case 5 -> questao5();
      case 6 -> questao6();
      case 7 -> questao7();
      case 8 -> questao8();
      case 9 -> questao9();
      case 10 -> questao10();
      case 11 -> questao11();
      case 12 -> questao12();
      case 13 -> questao13();
      case 14 -> questao14();
      case 15 -> questao15();
      case 16 -> questao16();
      default -> System.out.println("QuestÃ£o invÃ¡lida");
    }
  }

  // QuestÃµes
  // Desenvolva cada questÃ£o dentro dos mÃ©todos a seguir
  static void questao1() {
    int idade;
    idade = 19;

    if (idade >= 18) {
        System.out.println("Maior de idade!");
    } else {
        System.out.println("Menor de idade!");
    }
  }

  static void questao2() {
  int num;
    num =  7;

    if (num%2 ==0) {
      System.out.println("É par");
    } else {
      System.out.println("É impar");
    }
  }

  static void questao3() {
    int a;
    int b;
    a=5;
    b=8;

    if (a>b) {
      System.out.println("X é maior que Y");
    } else if (a==b) {
      System.out.println("São iguais");
    } else {
      System.out.println("Y é maior que X");
    }
  }

  static void questao4() {
    int clima;
    clima=22;

    if (clima>20) {
      System.out.println("Está quente");
    } else {
      System.out.println("Está frio");
    }
  }

  static void questao5() {
    float nota;
    nota=8.8f;

    if (nota>6.8) {
      System.out.println("Aprovado");
    } else {
      System.out.println("Reprovado");
    }
  }

  static void questao6() {
    double a;
    double preco;
    double total;
    a=89;

    if (a<=100) {
      preco=0.50;
    } else {
      preco=0.70;
    }
    total=a*preco;
    System.out.println("Consumo"+preco+"kwh");
    System.out.println("Valor total: R$ "+total);
  }

  static void questao7() {
    for (int contagem=10; contagem>=0; contagem--)
      System.out.println(contagem);
  }

  static void questao8() {
    int a;
    int soma;
    a=2;
    soma=0;
    
    while(a<=100) {
      soma+=a;
      a+=2;
    }
    System.out.println(soma);

  }

  static void questao9() {
    int numero;
    numero=6;

    for (int a=1; a<=10; a++) {
      System.out.println(numero+"x"+a+"="+(numero*a));
    }
  }

  static void questao10() {
    int num;
    int cont;
    num=2;
    cont=0;

    for (int x=1; x<=num; x++) 
      if (num%x==0)cont++;

    if (cont==2) {
      System.err.println("É primo");
    } else {
      System.out.println("Não é primo");
    }
  }

  static void questao11() {
    char letra;
    letra='a';

    switch (letra) {
      case 'a', 'e', 'i', 'o', 'u' -> System.out.println("Vogal");
      default -> System.out.println("Consoante");
    }
  }

  static void questao12() {
    String nome;
    int num;
    nome = "Ana";
    num = 0;

    for (int x= 0; x < nome.length(); x++)
    if (nome.charAt(x) == 'a' || nome.charAt(x) == 'A') num++; {
    }
    System.out.println(num);
  }
}

  static void questao13() {
    int[] x = {1, 2, 3};
    int num;
    num = 2;

    for (int y = 0; y < x.length; y++)
    if (x[y] == num) {
      System.out.println("Achou");
    }
  }

  static void questao14() {
    double[] num = {5, 6, 7, 8, 9};
    double a;
    a = 0;

    for (int x= 0; x< 5; x++)
    a += num[x];

      System.out.println(a / 5);
}

  static void questao15() {
    String[] frutas = {"Maçã", "Banana", "Uva", "Laranja", "Manga"};

      for (String fruta : frutas)
      System.out.println(fruta);
  
}
  static void questao16() {
    String[] frutas = {"banana", "morango", "melancia", "goiaba", "acerola"};

    for (int i = 0; i < frutas.length; i++) {
      char letra = frutas[i].charAt(0);

      if (letra == 'm' || letra == 'M') {
          System.out.println(frutas[i]);
        }
    }
}
