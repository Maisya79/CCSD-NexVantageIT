import { Box } from "@mui/material";
import Header from "../../../components/Header";
import myImage from "/app/src/HodViews/scense/dashboard/myImage.jpg"; // Correct import path


const DashboardAdmin = () =>{
    return <Box m="20px">
        <Box display="flex" justifyContent="space-between" alignItems="center">
            <Header title="DASHBOARD" subtitle = "Welcome to NexVantage IT Dashboard" />
        </Box>

        <Box mt="10px" display="flex" justifyContent="center">
            <img src={myImage} alt="Dashboard" width="100%" />
        </Box>
    </Box>
}

export default DashboardAdmin;