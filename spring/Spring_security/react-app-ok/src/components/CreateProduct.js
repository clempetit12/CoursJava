import {  useEffect, useRef, useState } from "react";
import { useNavigate, useParams } from 'react-router-dom';
import { productService } from "../services/productService";

const CreateProduct = () =>  {
    const {id} = useParams();
    const navigate = useNavigate();
    const [userData, setUserData] = useState({
      name: '', 
      price: '', 
  });

  useEffect(() => {
    if (id) {
      productService.getProductById(id)
        .then(product => {
          
          setUserData({
            name: product.name,
            price: product.price,
          });
        })
        .catch(error => {
          console.error('Error fetching product:', error);
      
        });
    }
  }, [id]);
    const handleChange = (e) => {
      const { name, value } = e.target;
      setUserData(prevState => ({
        ...prevState,
        [name]: value
      }));
    };
  
    const handleSubmit = async (e) => {
      e.preventDefault();
      try {
        const { name, price } = userData;
        if (id) {
            await productService.updateProduct(id, name, price);
            console.log('Product created successfully');
          } else {
            await productService.saveProduct(name, price); 
            console.log('Product updated successfully');
          }
    
        navigate('/products'); 
      } catch (error) {
        console.error('Error creating product:', error);
      }
    };
  
    return (
      <div className="container mt-5">
        <h2>Creation Product</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">Nom</label>
            <input
              type="text"
              className="form-control"
              id="name"
              name="name"
              value={userData.name}
              onChange={handleChange}
              required
            />
          </div>
          <div className="mb-3">
            <label htmlFor="email" className="form-label">Price</label>
            <input
              type="price"
              className="form-control"
              id="price"
              name="price"
              value={userData.price}
              onChange={handleChange}
              required
            />
          </div>
          <button type="submit" className="btn btn-primary">{id ? 'Update Product' : 'Create Product'}</button>
        </form>
      </div>
    );
  };
  
  export default CreateProduct;