import ProtectedRoute from "./components/ProtectedRoute";
import Login from './components/Login';
import Register from './components/Register';
import ProductList from './components/ProductList';
import Header from './shared/Header';
import CreateProduct from './components/CreateProduct';
import { createBrowserRouter } from "react-router-dom";


const router = createBrowserRouter([

    {
        path: "/",
        element: (
            <>
              <Header />
              <Login />
            </>
          ),
        children: [
          { path: "/", element: <Login /> },
          {path : "/register", element : <Register />},
          { path : "/products", element : <ProductList />},
          { path : "/create-product", element : <CreateProduct />},
          { path : "/create-product/:id", element :<CreateProduct />}
        
        ],
      },
    ]);
  

export default router;