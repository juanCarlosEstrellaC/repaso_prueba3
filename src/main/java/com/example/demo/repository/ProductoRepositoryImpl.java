package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.dto.ProductoDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ingresar(Producto producto) {
		this.entityManager.persist(producto);
	}

	@Override
	public Producto buscarPorCodigo(String codigo) {
		Query query = this.entityManager.createNamedQuery("Producto.buscarPorCodigo");
		query.setParameter("datoCod", codigo);
		return (Producto) query.getSingleResult();
	}

	// Método para buscar si existe un producto, y de no existir, devuelve una
	// excepción, por lo cual, uso un try-catch.
	@Override
	public Producto buscarPorCodigoTryCatch(String codigo) {
		Producto producto = null;
		try {
			producto = (Producto) entityManager
					.createNativeQuery("SELECT * FROM  producto  WHERE prod_codigo = :datoCod", Producto.class)
					.setParameter("datoCod", codigo).getSingleResult();
		} catch (NoResultException e) {
			System.out.println("NO existe");
		}
		return producto;
	}

	@Override
	public int actualizarStock(String codigo, BigDecimal nuevoSock) {
		Query query = this.entityManager
				.createNativeQuery("UPDATE producto SET prod_stock = :datoStock  WHERE  prod_codigo = :datoCodigo");
		query.setParameter("datoStock", nuevoSock);
		query.setParameter("datoCodigo", codigo);
		return query.executeUpdate();
	}

	@Override
	public List<Producto> buscarTodos() {
		Query query = this.entityManager.createNamedQuery("Productos.buscarTodos");
		return query.getResultList();
	}

	@Override
	public ProductoDTO buscarDto(String codigo) {
		TypedQuery<ProductoDTO> queryDto = this.entityManager.createQuery(
				"SELECT NEW com.example.demo.modelo.dto.ProductoDTO(p.codigo) FROM Producto p WHERE p.codigo = :datoCodigo",
				ProductoDTO.class);
		queryDto.setParameter("datoCodigo", codigo);
		return queryDto.getSingleResult();
	}

	@Override
	public Producto buscarPorCodigoCriteria(String codigo) {
		// 1. creamos la fabrica:
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		// 2. declaro el tipo de retorno del SQL:
		CriteriaQuery<Producto> myQuery = myBuilder.createQuery(Producto.class);

		// comenzamos a crear el "SQL"
		// 3. defino la tabla destino, ie, el FROM-Root:
		Root<Producto> miTablaFrom = myQuery.from(Producto.class); 

		// 4. Las condiciones WHERE se conocen en Criteria API Query como predicados.
		// el segundo argumento es con el que tengo que comparar.
		Predicate condicion1 = myBuilder.equal(miTablaFrom.get("codigo"), codigo); 
		
		// 5. Declaro mi Query
		myQuery.select(miTablaFrom).where(condicion1);

		// 6. La ejecución del query lo realizamos con cualquier tipo conocido.
		TypedQuery<Producto> mySQL = this.entityManager.createQuery(myQuery); 

		return mySQL.getSingleResult();
	}


}
