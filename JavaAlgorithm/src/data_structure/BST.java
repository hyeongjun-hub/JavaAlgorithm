package data_structure;


//binary search tree
public class BST {

    Node head = null;

    class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    public boolean insertNode(int data){
        //CASE 1: Node가 하나도 없을 때
        if(this.head == null){
            this.head = new Node(data);
        } else{
            //CASE 2: Node가 하나 이상 일 때
            Node findNode = this.head;
            while(true){
                //CASE 2-1: Node가 현재 Node의 왼쪽에 들어가야 할 때
                if(data < findNode.value){
                    if(findNode.left != null){
                        findNode = findNode.left;
                    }else{
                        findNode.left = new Node(data);
                        break;
                    }
                }else{
                    //CASE 2-2: Node가 현재 Node의 오른쪽에 들어가야 할 때
                    if(findNode.right != null){
                        findNode = findNode.right;
                    }else{
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        //CASE 1: Node가 하나도 없을 때
        if (this.head == null) {
            return null;
        }else{
            //CASE 2: Node가 하나 이상 있을 때
            Node findNode = this.head;
            while(findNode != null){
                if(data < findNode.value){
                    findNode = findNode.left;
                } else if (data > findNode.value) {
                    findNode = findNode.right;
                } else {
                    return findNode;
                }
            }
            return null;
        }
    }

    public boolean delete(int value){
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        //Corner CASE 1: Node가 하나도 없을 때
        if(this.head == null){
            return false;
        } else{
            //Corner CASE 2: Node가 하나만 있고, 해당 Node가 삭제할 Node일 때
            if(this.head.value == value && this.head.left == null && this.head.right == null){
                this.head = null;
                return true;
            }
            //탐색 시작
            while(currNode != null){
                if(currNode.value == value){
                    searched = true;
                    break;
                } else if(value < currNode.value){
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else{
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            //못찾았으면 false 리턴
            if(searched == false){
                return false;
            }

            //찾았으면 현재 currNode는 삭제할 노드
            //currParentNode는 삭제할 노드의 부모 노드

            //CASE 1: leafNode 일 때
            if (currNode.left == null && currNode.right == null) {
                if(value < currParentNode.value){
                    currParentNode.left = null;
                    currNode = null; // 안써도 됨
                } else {
                    currParentNode.right = null;
                    currNode = null; // 안써도 됨
                }
                return true;
            }
            //CASE 2-1: childNode 하나 일 때(currNode.left를 붙여야 함)
            else if (currNode.left != null && currNode.right == null) {
                if(value < currParentNode.value){
                    currParentNode.left = currNode.left;
                    currNode = null;
                }else{
                    currParentNode.right = currNode.left;
                    currNode = null;
                }
                return true;
            }
            //CASE 2-2: childNode 하나 일 때(currNode.right를 붙여야 함)
            else if (currNode.left == null) {
                if(value < currParentNode.value){
                    currParentNode.left = currNode.right;
                    currNode = null;
                }else{
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
                return true;
            }
            //CASE 3: childNode 둘 일 때
                //삭제한 Node의 오른쪽 자식들 중, 가장 작은 값(가장 왼쪽 값)을 빈 위치로 이동시킨다.(선택)
                //삭제한 Node의 왼쪽 자식들 중, 가장 큰 값을 빈 위치로 이동시킨다.
            else{
                Node changeParentNode = currNode.right;
                Node changeNode = currNode.right;
                while(changeNode.left != null){
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                //CASE 3-1: 삭제할 Node가 Parent Node의 왼쪽에 있을 때
                if (value < currParentNode.value) {
                    //Case 3-1-1: 삭제할 Node의 오른쪽 자식 중 가장 작은 값을 가진 Node의 오른 쪽에 Child Node가 있을 때
                    if (changeNode.right != null) {
                        changeParentNode.left = changeNode.right;
                    }
                    //Case 3-1-1: 삭제할 Node의 오른쪽 자식 중 가장 작은 값을 가진 Node의 오른 쪽에 Child Node가 없을 때
                    else{
                        changeParentNode.left = null;
                    }
                    currParentNode.left = changeNode;
                }
                //CASE 3-2: 삭제할 Node가 Parent Node의 오른쪽에 있을 때
                else{
                    //Case 3-2-1: 삭제할 Node의 오른쪽 자식 중 가장 작은 값을 가진 Node의 오른 쪽에 Child Node가 없을 때
                    if (changeNode.right != null) {
                        changeParentNode.left = changeNode.right;
                    }
                    //Case 3-2-1: 삭제할 Node의 오른쪽 자식 중 가장 작은 값을 가진 Node의 오른 쪽에 Child Node가 있을 때
                    else{
                        changeParentNode.left = null;
                    }
                    currParentNode.right = changeNode;
                }
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;
                currNode = null;
                return true;
            }
        }
    }

    public static void main(String[] args) {
        BST myTree = new BST();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }
}
