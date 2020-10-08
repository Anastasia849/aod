package ru.mirea.aod_practice10;


public class Tree{
    private Node root; // first node of tree

    public Node getRoot() {
        return root;
    }

    public Tree() // Конструктор
    { root = null; } // Пока нет ни одного узла

    public Node find(int key) // Поиск узла с заданным ключом
    { // (предполагается, что дерево не пустое)
        Node current = root; // Начать с корневого узла
        while(current.iData != key) // Пока не найдено совпадение
        {
            if(key < current.iData) // Двигаться налево?
                current = current.leftChild;
            else // Или направо?
                current = current.rightChild;
            if(current == null) // Если потомка нет,
                return null; // поиск завершился неудачей
        }
        return current; // Элемент найден
    }

    public void insert(int id)
    {
        Node newNode = new Node(); // Создание нового узла
        newNode.iData = id; // Вставка данных
        if(root==null) // Корневой узел не существует
            root = newNode;
        else // Корневой узел занят
        {
            Node current = root; // Начать с корневого узла
            Node parent;
            while(true) // (внутренний выход из цикла)
            {
                parent = current;
                if(id < current.iData) // Двигаться налево?
                {
                    current = current.leftChild;
                    if(current == null) // Если достигнут конец цепочки,
                    { // вставить слева
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else // Или направо?
                {
                    current = current.rightChild;
                    if(current == null) // Если достигнут конец цепочки,
                    { // вставить справа
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) // Удаление узла с заданным ключом
    {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key) // Поиск узла
        {
            parent = current;
            if (key < current.iData) // Двигаться налево?
            {
                isLeftChild = true;
                current = current.leftChild;
            } else // Или направо?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) // Конец цепочки
                return false; // Узел не найден
        }
        // Удаляемый узел найден
        // Если узел не имеет потомков, он просто удаляется.
        if (current.leftChild == null &&
                current.rightChild == null) {
            if (current == root) // Если узел является корневым,
                root = null; // дерево очищается
            else if (isLeftChild)
                parent.leftChild = null; // Узел отсоединяется
            else // от родителя
                parent.rightChild = null;
        }
        // Если нет правого потомка, узел заменяется левым поддеревом
        else if (current.rightChild == null)
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
            // Если нет левого потомка, узел заменяется правым поддеревом
        else if (current.leftChild == null)
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        else {
            // Поиск преемника для удаляемого узла (current)
            Node successor = getSuccessor(current);
            // Родитель current связывается с посредником
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // Преемник связывается с левым потомком current
            return true; // Признак успешного завершения
        }
        return true;
    }
        // Метод возвращает узел со следующим значением после delNode.
        // Для этого он сначала переходит к правому потомку, а затем
        // отслеживает цепочку левых потомков этого узла.
        private Node getSuccessor(Node delNode)
        {
            Node successorParent = delNode;
            Node successor = delNode;
            Node current = delNode.rightChild; // Переход к правому потомку
            while(current != null) // Пока остаются левые потомки
            {
                successorParent = successor;
                successor = current;
                current = current.leftChild; // Переход к левому потомку
            }
            // Если преемник не является
            if(successor != delNode.rightChild) // правым потомком,
            { // создать связи между узлами
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = delNode.rightChild;
            }
            return successor;
        }



    public void printTree(Node node) {
        if (node != null) {
            printTree(node.leftChild);
            System.out.println(node.iData);
            printTree(node.rightChild);
        }
    }

    }
