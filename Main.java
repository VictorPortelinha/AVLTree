public class Main {
    public static void main(String[] args) {
        int tamanho = 20;
        int[] vetor;
        vetor = GerarVetorAleatorio.gerarVetorAleatorio(tamanho);
        BinaryTree tree = new BinaryTree();

        for(int i=0;i<tamanho;i++){
            tree.insert(vetor[i]);
        }
        tree.traverseInOrder();
    }
}