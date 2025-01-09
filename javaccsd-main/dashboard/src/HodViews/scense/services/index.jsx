// import * as React from "react";
// import { Box, Typography, useTheme, Grid } from "@mui/material";
// import { tokens } from "../../../base/theme";
// import Header from "../../../components/Header";
// import { useNavigate, Link  } from 'react-router-dom';
//
// const Services = () => {
//     const theme = useTheme();
//     const colors = tokens(theme.palette.mode);
//     const navigate = useNavigate();
//
//     const boxContents = [
//         { title: "Add Products", imageUrl: "url-to-image1.jpg", description: "You can add product price and descriptions", link: "/add-product" },
//         // { title: "Edit Products", imageUrl: "url-to-image2.jpg", description: "You can edit product price and descriptions", link: "/services/subjects" },
//         // { title: "Delete Products", imageUrl: "url-to-image3.jpg", description: "You can delete already added products", link: "/classes" },
//
//     ];
//
//     return (
//         <Box>
//             <Header title="Manage Products" subtitle="Choose the boxes to add/edit/delete" />
//
//             <Box marginLeft="1%" marginRight="1%">
//             <Grid container spacing={2}>
//                     {boxContents.map((content, index) => (
//                         <Grid item xs={4} key={index}>
//                             <Link to={content.link} style={{ textDecoration: 'none', color: 'inherit' }}>
//                                 <Box
//                                     sx={{
//                                         height: "30vh",
//                                         border: "4px solid",
//                                         borderColor: theme.palette.mode === "dark" ? colors.primary[400] : colors.primary[100],
//                                         backgroundImage: `url(${content.imageUrl})`,
//                                         backgroundSize: "cover",
//                                         backgroundPosition: "center",
//                                         display: "flex",
//                                         alignItems: "center",
//                                         justifyContent: "center",
//                                         flexDirection: "column",
//                                         padding: "1rem",
//                                     }}
//                                 >
//                                     <Typography variant="h5">{content.title}</Typography>
//                                     <Typography variant="body1">{content.description}</Typography>
//                                 </Box>
//                             </Link>
//                         </Grid>
//                     ))}
//                 </Grid>
//
//             </Box>
//         </Box>
//     );
// };
//
// export default Services;
//
//
import React, { useState, useEffect } from "react";
import { Box, Typography, useTheme, Button, Grid } from "@mui/material";
import { DataGrid } from "@mui/x-data-grid";
import { Link } from "react-router-dom";
import EditOutlinedIcon from "@mui/icons-material/EditOutlined";
import DeleteOutlinedIcon from "@mui/icons-material/DeleteOutlined";
import AddCircleOutlineIcon from "@mui/icons-material/AddCircleOutline";
import axios from "axios";
import Header from "../../../components/Header";

const ProductTable = () => {
    const API_BASE_URL = "http://localhost:8082";
    const token = localStorage.getItem("jwtToken");
    const [products, setProducts] = useState([]);

    axios.defaults.withCredentials = true;

    // Fetch product data
    useEffect(() => {
        axios
            .get(`${API_BASE_URL}/api/products`, {
                headers: {
                    "Content-Type": "application/json",
                    Authorization: `Bearer ${token}`,
                },
            })
            .then((response) => {
                setProducts(response.data);
            })
            .catch((error) => console.error("Error fetching products:", error));
    }, []);

    // Handle delete function
    const handleDelete = (productId) => {
        axios
            .delete(`${API_BASE_URL}/api/products/${productId}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            })
            .then(() => {
                // Remove deleted product from state
                setProducts((prevProducts) =>
                    prevProducts.filter((product) => product.id !== productId)
                );
            })
            .catch((error) => console.error("Error deleting product:", error));
    };

    // Handle edit function (can be expanded)
    const handleEdit = (productId) => {
        console.log("Edit product with ID:", productId);
        // Redirect to an edit page or open a modal
    };

    // Define columns for DataGrid
    const columns = [
        { field: "id", headerName: "ID", flex: 0.5 },
        { field: "title", headerName: "Product Title", flex: 1 },
        {
            field: "actions",
            headerName: "Actions",
            flex: 1,
            renderCell: ({ row }) => (
                <Box display="flex" justifyContent="center" alignItems="center" gap={2}>
                    <Button
                        variant="contained"
                        color="primary"
                        size="small"
                        startIcon={<EditOutlinedIcon />}
                        onClick={() => handleEdit(row.id)}
                    >
                        Edit
                    </Button>
                    <Button
                        variant="contained"
                        color="error"
                        size="small"
                        startIcon={<DeleteOutlinedIcon />}
                        onClick={() => handleDelete(row.id)}
                    >
                        Delete
                    </Button>
                </Box>
            ),
        },
    ];

    // Map product data to rows for DataGrid
    const rows = products.map((product) => ({
        id: product.id,
        title: product.title || "N/A",
    }));

    return (
        <Box>
            <Header title="Products" subtitle="Managing Products" />
            <Box mt={2}>
                <DataGrid
                    rows={rows} // Use mapped rows
                    columns={columns}
                    pageSize={10}
                    autoHeight
                    sx={{
                        "& .MuiDataGrid-root": {
                            border: "none",
                        },
                        "& .MuiDataGrid-cell": {
                            borderBottom: "none",
                        },
                        "& .MuiDataGrid-columnHeaders": {
                            backgroundColor: "#3f51b5",
                            color: "#fff",
                            fontSize: 16,
                        },
                        "& .MuiDataGrid-virtualScroller": {
                            backgroundColor: "#445275",
                        },
                    }}
                />
            </Box>
            {/* Add Product Button */}
            <Link to="/add-product" style={{ textDecoration: "none" }}>
                <Grid container justifyContent="flex-end">
                    <Box sx={{ m: 2 }}>
                        <Button
                            startIcon={<AddCircleOutlineIcon />}
                            variant="contained"
                            size="large"
                            color="success"
                        >
                            Add Product
                        </Button>
                    </Box>
                </Grid>
            </Link>
        </Box>
    );
};

export default ProductTable;
