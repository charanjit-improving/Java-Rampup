public interface ProductRepository extends JpaRepository<Product, Long> {

    <T> List<T> findBy(Class<T> type);
}