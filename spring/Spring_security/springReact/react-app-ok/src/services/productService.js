import api from './api';
import { authHeader } from '../helpers/auth-header';
import { computeHeadingLevel } from '@testing-library/react';

const getAllProducts = () => {
  return api.get('/products', { headers: authHeader() });
};

const saveProduct = (name,price) => {
  return api.post('/products/admin/post', {name,price}, { headers: authHeader() }).then((response) => {
    return response.data
  })

}

const deleteProduct = (id) => {
  return api.delete(`/products/${id}`,{ headers: authHeader() } ).then((response) => {
    return response.data
  })
}

const updateProduct = (id,name,price) => {
  return api.put(`/products/update/${id}`, {id,name,price}, { headers: authHeader() }).then((response) => {
    return response.data
  })
}

const getProductById = (id) => {
  return api.get(`/products/${id}`, { headers: authHeader() }).then((response) => {
    return response.data
  })
}

export const productService = { getAllProducts, saveProduct,deleteProduct,updateProduct,getProductById};
