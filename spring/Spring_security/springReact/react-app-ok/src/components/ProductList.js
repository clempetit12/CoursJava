import React, { useEffect, useState } from 'react';
import { productService } from '../services/productService';
import { useNavigate } from 'react-router-dom';

function ProductList() {
  const [products, setProducts] = useState([]);
  const [error, setError] = useState('');
  const navigate = useNavigate();


  const deleteProduct = (id) => {
    productService.deleteProduct(id)  .then(response => {
      console.log(response)
      setProducts(prevProducts => prevProducts.filter(product => product.id !== id));
    })
    .catch(error => {
      setError('Erreur lors de la suppression du produit.');
    });

  }

  const updateProduct = (id) => {
    navigate(`/create-product/${id}`);
  }

    useEffect(() => {
    productService.getAllProducts()
      .then(response => {
        console.log(response)
        setProducts(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });
  }, []);

  return (
    <div className="container mt-5">
      <h2>Product List</h2>
      {error && <div className="alert alert-danger" role="alert">
        {error}
      </div>}
      <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Delete</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr key={product.id}>
              <th scope="row">{index + 1}</th>
              <td>{product.name}</td>
              <td>{product.price}</td>
              <td><button className='btn btn-outline-danger' onClick={() => deleteProduct(product.id)}>Delete <i className="bi bi-trash"></i></button></td>
              <td><button className='btn btn-outline-warning' onClick={() => updateProduct(product.id)}>Edit <i className="bi bi-trash"></i></button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ProductList;
