import java.util.*;

public class Main {

    public static void main(String args[]) {
      int size = 10000;
      Integer[] vetor = new Integer[size];
      LinkedList<Integer> linkedList = new LinkedList<>();
      ArrayList<Integer> arrayList = new ArrayList<>();
      Random random = new Random(10);
      for(int i = 0; i < size; i++) {
          vetor[i] = random.nextInt(size);
          linkedList.add(random.nextInt(size));
          arrayList.add(random.nextInt(size));
      }

      long tempoInicial = System.currentTimeMillis();

        //quickSort(vetor,0, (vetor.length - 1));
        //Arrays.sort(vetor);
        //mergeSort(vetor, 0, (vetor.length - 1));
        //selectionSort(vetor, vetor.length);
        //insertionSort(vetor, vetor.length);
        //bubbleSort(vetor, vetor.length);
        //-------------------------------------------//
        //quickSort(linkedList,0,size - 1);
        //Collections.sort(linkedList);
        //mergeSort(linkedList,0, size - 1);
        //selectionSort(linkedList,size);
        //insertionSort(linkedList, size);
        //bubbleSort(linkedList,size);
        //-------------------------------------------//
        //quickSort(arrayList,0,size - 1);
        //Collections.sort(arrayList);
        //mergeSort(arrayList,0, size - 1);
        //selectionSort(arrayList,size);
        //insertionSort(arrayList, size);
        //bubbleSort(arrayList,size);


      long tempoFinal = System.currentTimeMillis();

      long tempoTotal = (tempoFinal - tempoInicial);

      //printLinked(linkedList,size);
      //printVetor(vetor,size);
      //printArray(arrayList,size);

      System.out.println("--------------------------------------------------------------");

      System.out.println(tempoTotal);
    }
    // VETOR
    //bubbleSortTime = 9416728
    //insertionSortTime = 4266957
    //selectionSortTime = 3322346
    //mergeSortTime = 1040
    //quickSortTime = 721
    //arraySortTime = 1330
    //collectionSortTime = undefined

    //--------------------------------------//

    // LINKED LIST //
    //---10.000/
    //bubbleSortTime = 963996
    //insertionSortTime = 649767
    //selectionSortTime = 360864
    //---10.000/
    //50.000//
    //mergeSortTime = 117116`
    //quickSortTime = 80455
    //arraySortTime = undefined
    //collectionSortTime = 1145
    // 50.000 //

    //--------------------------------------//

    // ARRAY
    //bubbleSortTime = 9693862
    //insertionSortTime = 5620415
    //selectionSortTime = 5446617
    //mergeSortTime = 1177
    //quickSortTime = 805
    //arraySortTime = undefined
    //collectionSortTime = 1209

    public static void printVetor(Integer[] vetor, int n) {
        for(int i=0; i<n; i++) {
            System.out.println(vetor[i]+" ");
        }
        System.out.println();
    }

    public static void printLinked(LinkedList<Integer> linkedList, int n) {
        for(int i = 0; i < n; i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println();
    }

    public static void printArray (ArrayList<Integer> arrayList, int n) {
        for(int i=0; i<n; i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println();
    }

    // VETOR

    public static void bubbleSort(Integer[] vetor, int n) {
        boolean swap = false;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(vetor[j]>vetor[j+1]) {
                    int aux = vetor[j];
                    vetor[j]=vetor[j+1];
                    vetor[j+1] = aux;
                    swap = true;
                }
            }
            if(swap) {
                swap = false;
            }else {
                break;
            }
        }
    }

    public static void selectionSort(Integer[] vetor, int n) {
        int menor;
        int idxMenor;

        for(int i=0; i<n-1; i++) {
            menor = vetor[i];
            idxMenor = i;
            for(int j=i+1; j<n; j++) {
                if(menor > vetor[j]) {
                    menor = vetor[j];
                    idxMenor = j;
                }
            }
            int aux = vetor[i];
            vetor[i] = menor;
            vetor[idxMenor] = aux;
        }
    }

    public static void insertionSort(Integer[] vetor, int n) {
        for(int i=1; i<n; i++) {
            int aux = vetor[i];
            for(int j=i; j>=0; j--) {
                if(j==0) {
                    vetor[j] = aux;
                    break;
                }
                if(aux<vetor[j-1]) {
                    vetor[j] = vetor[j-1];
                }else {
                    vetor[j] = aux;
                    break;
                }
            }
        }
    }

    static void mergeSort(Integer[] vetor, int inicio, int fim) {
        if(inicio == fim)
            return;
        int meio = (inicio+fim)/2;

        //System.out.println("mergeSort(esq) -> inicio = "+inicio+", fim = "+meio);
        mergeSort(vetor, inicio, meio);

        //System.out.println("mergeSort(dir) -> inicio = "+(meio+1)+", fim = "+fim);
        mergeSort(vetor, meio+1, fim);

        //System.out.println("merge -> inicio = "+inicio+", meio = "+meio+", fim = "+fim);
        merge(vetor, inicio, meio, fim);
        //print(vetor, 10);
        //System.out.println();
    }

    static void merge(Integer[] vetor, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio+1;
        int k = 0;
        Integer vetAux[] = new Integer[fim-inicio+1];
        while(i<=meio && j<=fim) {
            if(vetor[i] < vetor[j]) {
                vetAux[k] = vetor[i];
                i++;
                k++;
            }else {
                vetAux[k] = vetor[j];
                j++;
                k++;
            }
        }
        while(i <= meio) {
            vetAux[k] = vetor[i];
            i++;
            k++;
        }
        while(j<=fim) {
            vetAux[k] = vetor[j];
            j++;
            k++;
        }
        for(k=0; k<fim-inicio+1; k++) {
            vetor[inicio+k] = vetAux[k];
        }
    }


    static void quickSort(Integer[] vetor, int inicio, int fim) {
        int i = inicio;
        int j = fim;
        int meio = (inicio+fim)/2;
        int pivo = vetor[meio];

        while(i <= j) {
            while(vetor[i] < pivo) {
                i++;
            }
            while(vetor[j] > pivo) {
                j--;
            }
            if( i <= j) {
                int aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
            }
        }
        //System.out.println("inicio = "+inicio+", fim = "+fim+", pivo = "+pivo);
        //print(vetor, 10);
        //System.out.println();
        if(inicio < j) {
            quickSort(vetor, inicio, j);
        }
        if(i < fim) {
            quickSort(vetor, i, fim);
        }
    }

    // LINKED LIST

    public static void insertionSort(LinkedList<Integer> linkedList, int n) {
        for(int i=1; i<n; i++) {
            int aux = linkedList.get(i);
            for(int j=i; j>=0; j--) {
                if(j==0) {
                    linkedList.set(j, aux);
                    break;
                }
                if(aux < linkedList.get(j - 1)) {
                    linkedList.set(j, linkedList.get(j - 1));
                }else {
                    linkedList.set(j, aux);
                    break;
                }
            }
        }
    }

    public static void bubbleSort(LinkedList<Integer> linkedList, int n) {
        boolean swap = false;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(linkedList.get(j) > linkedList.get(j + 1)) {

                    int aux = linkedList.get(j);
                    linkedList.set(j, linkedList.get(j + 1));
                    linkedList.set(j + 1, aux);
                    swap = true;
                }
            }
            if(swap) {
                swap = false;
            }else {
                break;
            }
        }
    }

    public static void selectionSort(LinkedList<Integer> linkedList, int n) {
        int menor;
        int idxMenor;

        for(int i=0; i<n-1; i++) {
            menor = linkedList.get(i);
            idxMenor = i;
            for(int j=i+1; j<n; j++) {
                if(menor > linkedList.get(j)) {
                    menor = linkedList.get(j);
                    idxMenor = j;
                }
            }
            int aux = linkedList.get(i);
            linkedList.set(i, menor);
            linkedList.set(idxMenor, aux);
        }
    }

    static void mergeSort(LinkedList<Integer> linkedList, int inicio, int fim) {
        if(inicio == fim)
            return;
        int meio = (inicio+fim)/2;

        //System.out.println("mergeSort(esq) -> inicio = "+inicio+", fim = "+meio);
        mergeSort(linkedList, inicio, meio);

        //System.out.println("mergeSort(dir) -> inicio = "+(meio+1)+", fim = "+fim);
        mergeSort(linkedList, meio+1, fim);

        //System.out.println("merge -> inicio = "+inicio+", meio = "+meio+", fim = "+fim);
        merge(linkedList, inicio, meio, fim);
        //print(vetor, 10);
        //System.out.println();
    }

    static void merge(LinkedList<Integer> linkedList, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio+1;
        int k = 0;
        Integer vetAux[] = new Integer[fim-inicio+1];
        while(i<=meio && j<=fim) {
            if(linkedList.get(i) < linkedList.get(j)) {
                vetAux[k] = linkedList.get(i);
                i++;
                k++;
            }else {
                vetAux[k] = linkedList.get(j);
                j++;
                k++;
            }
        }
        while(i <= meio) {
            vetAux[k] = linkedList.get(i);
            i++;
            k++;
        }
        while(j<=fim) {
            vetAux[k] = linkedList.get(j);
            j++;
            k++;
        }
        for(k=0; k<fim-inicio+1; k++) {
            linkedList.set(inicio + k, vetAux[k]);
        }
    }

    static void quickSort(LinkedList<Integer> linked, int inicio, int fim) {
        int i = inicio;
        int j = fim;
        int meio = (inicio+fim)/2;
        int pivo = linked.get(meio);

        while(i <= j) {
            while(linked.get(i) < pivo) {
                i++;
            }
            while(linked.get(j) > pivo) {
                j--;
            }
            if( i <= j) {
                int aux = linked.get(i);
                linked.set(i, linked.get(j));
                linked.set(j, aux);
                i++;
                j--;
            }
        }
        //System.out.println("inicio = "+inicio+", fim = "+fim+", pivo = "+pivo);
        //print(vetor, 10);
        //System.out.println();
        if(inicio < j) {
            quickSort(linked, inicio, j);
        }
        if(i < fim) {
            quickSort(linked, i, fim);
        }
    }

    // ARRAY

    public static void insertionSort(ArrayList<Integer> arrayList, int n) {
        for(int i=1; i<n; i++) {
            int aux = arrayList.get(i);
            for(int j=i; j>=0; j--) {
                if(j==0) {
                    arrayList.set(j, aux);
                    break;
                }
                if(aux < arrayList.get(j - 1)) {
                    arrayList.set(j, arrayList.get(j - 1));
                }else {
                    arrayList.set(j, aux);
                    break;
                }
            }
        }
    }

    public static void bubbleSort(ArrayList<Integer> arrayList, int n) {
        boolean swap = false;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(arrayList.get(j) > arrayList.get(j + 1)) {

                    int aux = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, aux);
                    swap = true;
                }
            }
            if(swap) {
                swap = false;
            }else {
                break;
            }
        }
    }

    public static void selectionSort(ArrayList<Integer> arrayList, int n) {
        int menor;
        int idxMenor;

        for(int i=0; i<n-1; i++) {
            menor = arrayList.get(i);
            idxMenor = i;
            for(int j=i+1; j<n; j++) {
                if(menor > arrayList.get(j)) {
                    menor = arrayList.get(j);
                    idxMenor = j;
                }
            }
            int aux = arrayList.get(i);
            arrayList.set(i, menor);
            arrayList.set(idxMenor, aux);
        }
    }

    static void mergeSort(ArrayList<Integer> arrayList, int inicio, int fim) {
        if(inicio == fim)
            return;
        int meio = (inicio+fim)/2;

        //System.out.println("mergeSort(esq) -> inicio = "+inicio+", fim = "+meio);
        mergeSort(arrayList, inicio, meio);

        //System.out.println("mergeSort(dir) -> inicio = "+(meio+1)+", fim = "+fim);
        mergeSort(arrayList, meio+1, fim);

        //System.out.println("merge -> inicio = "+inicio+", meio = "+meio+", fim = "+fim);
        merge(arrayList, inicio, meio, fim);
        //print(vetor, 10);
        //System.out.println();
    }

    static void merge(ArrayList<Integer> arrayList, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio+1;
        int k = 0;
        Integer vetAux[] = new Integer[fim-inicio+1];
        while(i<=meio && j<=fim) {
            if(arrayList.get(i) < arrayList.get(j)) {
                vetAux[k] = arrayList.get(i);
                i++;
                k++;
            }else {
                vetAux[k] = arrayList.get(j);
                j++;
                k++;
            }
        }
        while(i <= meio) {
            vetAux[k] = arrayList.get(i);
            i++;
            k++;
        }
        while(j<=fim) {
            vetAux[k] = arrayList.get(j);
            j++;
            k++;
        }
        for(k=0; k<fim-inicio+1; k++) {
            arrayList.set(inicio + k, vetAux[k]);
        }
    }

    static void quickSort(ArrayList<Integer> arrayList, int inicio, int fim) {
        int i = inicio;
        int j = fim;
        int meio = (inicio+fim)/2;
        int pivo = arrayList.get(meio);

        while(i <= j) {
            while(arrayList.get(i) < pivo) {
                i++;
            }
            while(arrayList.get(j) > pivo) {
                j--;
            }
            if( i <= j) {
                int aux = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, aux);
                i++;
                j--;
            }
        }
        //System.out.println("inicio = "+inicio+", fim = "+fim+", pivo = "+pivo);
        //print(vetor, 10);
        //System.out.println();
        if(inicio < j) {
            quickSort(arrayList, inicio, j);
        }
        if(i < fim) {
            quickSort(arrayList, i, fim);
        }
    }

}
