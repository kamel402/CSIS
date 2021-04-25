function validateCar() {

    var valid = true;

    //Validate the manufacturer field
    
    if (document.getElementById("manufacturer").value == "Select one manufacturer") {
        valid = false;
        document.getElementById("manufacturer").value = "Select one manufacturer";
        document.getElementById("manufacturer").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("manufacturer").style = "none";
    }


    //Validate the model field
    if (document.getElementById("model").value.search(/^.{6,}$/) != 0 || document.getElementById("model").value.search(/.*\S.*/) != 0|| document.getElementById("model").value == "Enter at least 6 characters")         
    {
        valid = false;
        document.getElementById("model").value = "Enter at least 6 characters";
        document.getElementById("model").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("model").style = "none";
    }


    //Validate the type field
    if (document.getElementById("type").value == "Select one type") {
        valid = false;
        document.getElementById("type").value = "Select one type";
        document.getElementById("type").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("type").style = "none";
    }
    
    //Validate the Year of Manufacturing field
    if (document.getElementById("year").value.search(/^[0-9]*$/) != 0 || document.getElementById("year").value < 1970 || document.getElementById("year").value > 2021 || document.getElementById("year").value == "Invalid year")      
    {
        valid = false;
        document.getElementById("year").value = "Invalid year";
        document.getElementById("year").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("year").style = "none";
    }
    
    //Validate the Miles field
    if (document.getElementById("miles").value.search(/^[0-9]*$/) != 0 ||  document.getElementById("miles").value == "" || document.getElementById("miles").value == "Invalid miles")      
    {
        valid = false;
        document.getElementById("miles").value = "Invalid miles";
        document.getElementById("miles").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("miles").style = "none";
    }

    //Validate the Price field
    if (document.getElementById("price").value.search(/^(?:[1-9]\d*|0)?(?:\.\d+)?$/) != 0 || document.getElementById("price").value == "" || document.getElementById("price").value == "Invalid price")      
    {
        valid = false;
        document.getElementById("price").value = "Invalid price";
        document.getElementById("price").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("price").style = "none";
    }
    
    //Validate the Comments field
    if (document.getElementById("comments").value.search(/^.{20,}$/) != 0 || document.getElementById("comments").value.search(/.*\S.*/) != 0 || document.getElementById("comments").value == "Enter at least 20 characters")        
    {
        valid = false;
        document.getElementById("comments").value = "Enter at least 20 characters";
        document.getElementById("comments").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("comments").style = "none";
    }

    
    if (valid == false) {
        return false;    // don't submit the form data to the server because of validation error(s)
    }
    else {
        return true;     // submit the form data to the server because all data looks correct
    }

}


// Functions to delete error messages

function changeModel() {
    let pass = document.getElementById("model");
    if (pass.value == "Enter at least 6 characters") {
        pass.value = "";
    }
}
function changeYear(){
    let pass = document.getElementById("year");
    if (pass.value == "Invalid year") {
        pass.value = "";
    }
}
function changeMiles(){
    let pass = document.getElementById("miles");
    if (pass.value == "Invalid miles") {
        pass.value = "";
    }
}
function changePrice(){
    let pass = document.getElementById("price");
    if (pass.value == "Invalid price") {
        pass.value = "";
    }
}
function changeComments(){
    let pass = document.getElementById("comments");
    if (pass.value == "Enter at least 20 characters") {
        pass.value = "";
    }
}

// after the full page is loaded this function will be excuted
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("model").onclick = changeModel;
    document.getElementById("year").onclick = changeYear;
    document.getElementById("miles").onclick = changeMiles;
    document.getElementById("price").onclick = changePrice;
    document.getElementById("comments").onclick = changeComments;
});


