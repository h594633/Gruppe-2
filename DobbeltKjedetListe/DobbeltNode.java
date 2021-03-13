public class DobbeltNode<T> {
        private T element;
        private DobbeltNode<T> neste;
        private DobbeltNode<T> forrige;


    public DobbeltNode(){
        neste = null;
        forrige = null;
        element = null;
    }
    public DobbeltNode(T elem) {
        element = elem;
        neste = null;
        forrige = null;
    }
    public DobbeltNode<T> getNeste() {
        return neste;
    }
    public DobbeltNode<T> getForrige() {
        return forrige;
    }
    public void setNeste(DobbeltNode<T> dnode) {
        neste = dnode;
    }
    public void setForrige(DobbeltNode<T> dnode){
            forrige = dnode;
    }
    public T getElement() {
        return element;
    }
    public void setElement(T elem) {
        element = elem;
    }
}
