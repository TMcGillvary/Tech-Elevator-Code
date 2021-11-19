let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}


/**
 * Event Listener for loading initial DOM javascript
 */
document.addEventListener("DOMContentLoaded", () => {

  // set page title
  setPageTitle();
  // display list of groceries
  displayGroceries();

  const groceryItems = document.querySelectorAll("li");

  groceryItems.forEach((item) => {

    // when you click on an item, mark it completed
    item.addEventListener("click", () => {
      markCompleted(item);
    });

    // when you double click on an item, mark it incomplete
    item.addEventListener("dblclick", () => {
      markIncomplete(item);
    });

  });

  // mark all items as completed
  const completeBtn = document.getElementById("toggleAll");

  completeBtn.addEventListener("click", () => {

    if (allItemsIncomplete === true) {
      allItemsIncomplete = false;
      completeBtn.innerText = "Mark All Incomplete";

      groceryItems.forEach((item) => {
        markCompleted(item);
      });

    } else {
      allItemsIncomplete = true;
      completeBtn.innerText = "Mark All Complete";

      groceryItems.forEach((item) => {
        markIncomplete(item);
      });
    }

  });

});

/**
 * This function takes the current item in the array and marks it as completed,
 * if it is not complete.
 * @param {item} item The current array item being iterated over
 */
function markCompleted(item) {
  if (!item.classList.contains("completed")) {
    item.classList.add("completed");
    item.querySelector("i").classList.add("completed");
  }
}

/**
 * This function takes the current item in the array and marks it as incomplete,
 * if it is completed.
 * @param {item} item The current array item being iterated over
 */
function markIncomplete(item) {
  if (item.classList.contains("completed")) {
    item.classList.remove("completed");
    item.querySelector("i").classList.remove("completed");
  }
}
