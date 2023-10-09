public class BinaryTree {
    Node root;
    public BinaryTree(){
        root = null;
    }
    public void delete(int data){
        root = delete(data,root);
    }
    public Node delete(int data,Node node){
        if(node == null){
            return null;
        }
        if(node.getData() == data){
            System.out.println("O número "+data+" foi removido");
            if(node.getEsquerda() == null){
                return node.getDireita();
            }else if(node.getDireita()== null){
                return node.getEsquerda();
            }
            node.setData(getMax(node.getEsquerda()));
            node.setEsquerda(delete(node.getData(),node.getEsquerda()));
        }
        else if(data <= node.getData()){
            node.setEsquerda(delete(data,node.getEsquerda()));
        }else if(data >= node.getData()){
            node.setDireita(delete(data,node.getDireita()));
        }

        return node;
    }
    public void search(int data){
        root = search(data,root);
    }
    public Node search(int data,Node node){
        if(node == null){
            return null;
        }
        if(node.getData() == data){
            System.out.println("O número "+data+" foi encontrado");
        }else if(data <= node.getData()){
            node.setEsquerda(search(data,node.getEsquerda()));
        }else if(data >= node.getData()){
            node.setDireita(search(data,node.getDireita()));
        }

        return node;
    }

    public void insert(int data){
        root = insert(data,root);
    }
    public Node insert(int data,Node node){
        if(node == null){
            return new Node(data); // se a raiz estiver vazia
        }
        // Percorre o a esquerda ou a direita comparando seu valor com o nó anterior
        if(data <= node.getData()){
            node.setEsquerda(insert(data,node.getEsquerda()));
        }else if(data >= node.getData()){
            node.setDireita(insert(data,node.getDireita()));
        }
        return node;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int getMin(){
        if(isEmpty()){
            System.out.println("A arvore está vazia, insira um elemento");
            return 0;
        }
        // chama a primeira recursão em outro método que aceita parametros
        return getMin(root);
    }
    private int getMin(Node node){
        if(node.getEsquerda() != null){
            return getMin(node.getEsquerda());
        }
        return node.getData();
    }
    public int getMax(){
        if(isEmpty()){
            System.out.println("A arvore binária está vazia, insira um elemento");
            return 0;
        }
        // chama a primeira recursão em outro método que aceita parametros
        return getMax(root);
    }
    private int getMax(Node node){
        if(node.getDireita() != null){
            return getMax(node.getEsquerda());
        }
        return node.getData();
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }
    private void traverseInOrder(Node node){
        if(node != null){
            traverseInOrder(node.getEsquerda());
            System.out.println(node.getData());
            traverseInOrder(node.getDireita());
        }
    }
}

