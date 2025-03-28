let authors = [];

function addAuthor() {
    const name = document.getElementById("authorName").value.trim();
    const publisher = document.getElementById("publisher").value.trim();
    const bookCount = document.getElementById("bookCount").value.trim();

    if (name === "" || publisher === "" || bookCount === "") {
        alert("Please fill in all fields.");
        return;
    }

    authors.push({ name, publisher, books: parseInt(bookCount) });
    document.getElementById("authorName").value = "";
    document.getElementById("publisher").value = "";
    document.getElementById("bookCount").value = "";

    updateTable();
}

function updateTable() {
    const tableBody = document.getElementById("authorTable");
    tableBody.innerHTML = "";

    authors.forEach((author, index) => {
        let row = `<tr>
            <td>${author.name}</td>
            <td>${author.publisher}</td>
            <td>${author.books}</td>
            <td><button class="remove-btn" onclick="removeAuthor(${index})">Remove</button></td>
        </tr>`;
        tableBody.innerHTML += row;
    });
}

function removeAuthor(index) {
    authors.splice(index, 1);
    updateTable();
}

function sortAuthors() {
    const sortOption = document.getElementById("sortOption").value;

    if (sortOption === "name") {
        authors.sort((a, b) => a.name.localeCompare(b.name));
    } else if (sortOption === "publisher") {
        authors.sort((a, b) => a.publisher.localeCompare(b.publisher));
    } else if (sortOption === "books") {
        authors.sort((a, b) => a.books - b.books);
    }

    updateTable();
}

function downloadList() {
    if (authors.length === 0) {
        alert("No authors to download.");
        return;
    }

    let textContent = "Author List:\n\n";
    authors.forEach(author => {
        textContent += `Name: ${author.name}\nPublisher: ${author.publisher}\nBooks: ${author.books}\n\n`;
    });

    const blob = new Blob([textContent], { type: "text/plain" });
    const link = document.createElement("a");
    link.href = URL.createObjectURL(blob);
    link.download = "AuthorList.txt";
    link.click();
}
