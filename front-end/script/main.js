/*********
 *CONSTANTS*
 **********/

const apiUrl = 'http://localhost:8080/api/v1/pizza';
let urlModified = apiUrl;
const root = document.getElementById('root');

/************
 * FUNCTIONS*
 ************/

// pizza list

const renderIngredients = (ingredients) => {

    let renderIngredient;

    if (ingredients.length === 0) {
        renderIngredient = 'No ingredients';
    } else {
        renderIngredient = '<ul class="list">';
        ingredients.forEach((ingr) => {
            renderIngredient += `<li>${ingr.name}</li>`;
        });
        renderIngredient += '</ul>';
    }
    return renderIngredient;

}

const renderPizza = (element) => {
    return `<div class="card shadow h-100">
                    <div class="card-body">

                        <h5 class="card-title">${element.name}</h5>

                        <h6 class="card-subtitle mb-2 text-body-secondary">${element.description}</h6>

                        <p class="card-text">${renderIngredients(element.ingredients)}</p>

                    </div>
                    <div class="card-footer">
                        <span>${element.price}</span>
                        <button onclick="deletePizza(${element.id})" type="button" class="btn btn-outline-primary mx-3" data-mdb-ripple-init>X</button>
                    </div>
                </div>`;
}

const renderPizzaList = (pizzas) => {
    let pizzasRender;
    console.log(pizzas);

    if (pizzas.length > 0) {

        pizzasRender = '<div class="row">';

        pizzas.forEach((element) => {
            pizzasRender += '<div class="col-3 my-3">';
            pizzasRender += renderPizza(element);
            pizzasRender += '</div>';
        });

        pizzasRender += '</div>';

    } else {
        pizzasRender = '<div class="alert alert-info">The list is empty</div>';
    }

    root.innerHTML = pizzasRender;
};

const getPizzaList = async () => {

    try {
        const response = await axios.get(urlModified);
        renderPizzaList(response.data);
    } catch (error) {
        console.log(error);
    }
};

getPizzaList();


// search pizza

function searchPizza() {
    const searchWord = document.getElementById('pizzaNameSearch').value;

    if (searchWord != '') {
        urlModified += "?search=";
        urlModified += searchWord;
    } else {
        urlModified = apiUrl;
    }

    getPizzaList();
};




// create pizza

document.getElementById('newPizzaForm').addEventListener('submit', function (event) {
    event.preventDefault();

    try {
        var formData = new FormData(event.target);

        fetch('http://localhost:8080/api/v1/pizza', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                name: formData.get('name'),
                price: formData.get('price'),
                image: formData.get('image'),
                description: formData.get('description')
            }),
        })
            .then(response => {
                if (response.error) {
                    throw new Error('Failed to create new pizza');
                }
                return window.location.replace("http://127.0.0.1:5500/index.html");

            })
    } catch (error) {
        console.error('unexpected error', error);
    }

});




// delete pizza http://localhost:8080/api/v1/pizza/5

function deletePizza(x) {

    urlModified += "/";
    urlModified += x;

    axios.delete(urlModified);

    setTimeout(function () {
        location.reload();
    }, 1000);
}

