import {
  Avatar,
  Button,
  FormControl,
  Grid,
  InputLabel,
  MenuItem,
  OutlinedInput,
  Paper,
  Select,
  TextField,
  Typography,
} from "@mui/material";
import React, { useEffect, useState } from "react";
import "../Style/Auth.css";
import axios from "axios";
import AddCircleOutlineOutlinedIcon from "@mui/icons-material/AddCircleOutlineOutlined";
import base_url from "../api/bootapi";
// import Evm from "./Evm";
import { useNavigate } from "react-router-dom";
export default function Auth() {
  const handleForm = (e) => {
    console.log("here");
    console.log(voter);
    setShouldShowNextPage(true);
    e.preventDefault();
  };
  const [shouldShowNextPage, setShouldShowNextPage] = useState(false);
  let cnt = 0;
  const navigate = useNavigate();
  const [voter, setVoter] = useState([]);
  useEffect(() => {
    getAllState();
  }, []);
  const getAllState = () => {
    axios.get(`${base_url}/states/getAllStates`).then(
      (response) => {
        setState(response.data);
        console.log(response.data);
        // console.log(states._id)
      },
      (error) => {
        console.log("Failed!!");
        console.log(error);
      }
    );
  };

  const [states, setState] = useState([]);
  const [constituency, setConstituency] = useState([]);
  const [selectedState, setSelectedState] = useState("");
  const getAllConstituencyFromState = (state) => {
    axios
      .get(`${base_url}/constituency/getConstituencyListFromState/${state}`)
      .then(
        (response) => {
          setConstituency(response.data);
          console.log(response.data);
        },
        (error) => {
          console.log("Failed");
          console.log(error);
        }
      );
  };
  return (
    <Grid className="gridStyle">
      <Paper elevation={20} className="paperStyle">
        <Grid align="center">
          <Avatar>
            <AddCircleOutlineOutlinedIcon />
          </Avatar>
          <h2 className="headerStyle">Add Voter</h2>
          <Typography>Please fill your information correctly!</Typography>
        </Grid>
        {shouldShowNextPage ? (
          navigate("/evm", { state: voter })
        ) : (
          <form onSubmit={handleForm}>
            <TextField
              style={{ marginTop: 10 }}
              fullWidth
              id="adhar"
              onChange={(e) => {
                setVoter({ ...voter, adharId: e.target.value });
              }}
              label="Adhar Id"
              placeholder="Enter your adhar card no"
            />
            <TextField
              style={{ marginTop: 10 }}
              fullWidth
              label="Voter Id"
              id="voter_id"
              onChange={(e) => {
                setVoter({ ...voter, voterId: e.target.value });
              }}
              placeholder="Enter your voter id"
            />

            <FormControl sx={{ marginTop: 1, width: 310 }}>
              <InputLabel id="demo-multiple-name-label">State</InputLabel>
              <Select
                input={<OutlinedInput label="State" />}
                value={states.stateName}
                onChange={(e) => {
                  setVoter({ ...voter, states: e.target.value });
                  setSelectedState(e.target.value);
                  console.log(selectedState);
                  // if(selectedState != null)
                  // setTimeout(() => {
                  getAllConstituencyFromState(e.target.value);
                  // }, 1000);
                  // console.log(e.target.value)
                }}
                inputProps={{
                  name: "stateName",
                  id: "id",
                }}
              >
                <MenuItem>
                  <em>None</em>
                </MenuItem>
                {states.map((item) => {
                  return (
                    <MenuItem key={cnt++} value={item.stateName}>
                      {item.stateName}
                    </MenuItem>
                  );
                })}
              </Select>
            </FormControl>

            <FormControl sx={{ marginTop: 1, width: 310 }}>
              <InputLabel id="demo-multiple-name-label">
                Constituency
              </InputLabel>
              <Select
                input={<OutlinedInput label="Constituency" />}
                value={constituency.constituency}
                onChange={(e) => {
                  setVoter({ ...voter, constituency: e.target.value });
                }}
                inputProps={{
                  name: "Constituency",
                  id: "id",
                }}
              >
                <MenuItem>
                  <em>None</em>
                </MenuItem>
                {constituency.map((item) => {
                  return (
                    <MenuItem key={item.id} value={item.constituency}>
                      {item.constituency}
                    </MenuItem>
                  );
                })}
              </Select>
            </FormControl>

            <Button
              style={{ marginTop: 10, display: "block" }}
              type="submit"
              variant="contained"
            >
              Add
            </Button>
          </form>
        )}
      </Paper>
    </Grid>
  );
}
