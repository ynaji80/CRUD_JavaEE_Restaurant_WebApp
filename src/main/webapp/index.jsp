<%@ page import="com.restau.dao.RestaurantDaoImp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.restau.models.Restaurant" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Niramit:ital,wght@0,300;0,400;0,600;0,700;1,300&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Niramit:ital,wght@0,300;0,400;0,600;0,700;1,300&family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700&display=swap" rel="stylesheet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style/css/all.min.css" >
    <meta charset="utf-8">
    <title>Restaurant App.</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script>
        tailwind.config={
            mode:'jit',
            theme: {
                extend: {
                    fontFamily: {
                        'body':["Lato",'sans-serif'],
                        'roboto':["Roboto",'sans-serif'],
                        'poppings':["Poppings",'sans-serif'],
                        'niramit':["Niramit",'sans-serif'],
                        'black':["Black Han Sans",'sans-serif']
                    },
                    boxShadow: {
                        '5xl': '20px 20px 20px rgba(0,0,1,0.5)',
                    }
                },
            }
        }
    </script>
    <style type="text/tailwindcss">
        @layer utilities {
            .content-auto {
                content-visibility: auto;
            }
        }
    </style>
</head>

<body>

<div class=" bg-gray-50  flex flex-col">
    <img src="https://blog.gotenzo.com/hubfs/igor-miske-JVSgcV8_vb4-unsplash-1.jpg"
         class="relative top-0 max-w-none object-cover w-full h-[550px]" />
    <div class="mt-10 flex space-x-8 max-w-6xl mx-auto p-4">
        <h1 class="text-3xl font-bold font-heading text-gray-600">
            Add a new restaurant
        </h1>
        <button id="modal-btn" class="bg-sky-500 hover:bg-sky-600 text-white font-bold py-2 px-4 rounded-lg">
            Add restaurant
        </button>
    </div>
    <div id="modal" class="hidden">
        <div class="flex justify-center px-6 my-12">
            <div class="flex w-3/4">
                <img
                        class=" h-auto bg-gray-400 hidden lg:block w-5/12 object-cover rounded-l-lg"
                        src="https://images.unsplash.com/photo-1564495584622-0bb3af6f668e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80"
                />
                <div class="w-7/12 bg-white p-5 rounded-r-lg">
                    <h3 class="pt-4 text-2xl text-center">Add a new restaurant!</h3>
                    <form action="AddRestaurant" method="post" enctype="multipart/form-data" class="px-8 pt-6 pb-8 mb-4 bg-white rounded">
                        <div class="mb-4">
                            <label class="block mb-2 text-sm font-bold text-gray-700" for="name">
                                Restaurant Name
                            </label>
                            <input
                                    class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                    name="name"
                                    type="text"
                                    placeholder="Restaurant Name"
                            />
                        </div>
                        <div class="mb-4">
                            <label class="block mb-2 text-sm font-bold text-gray-700" for="address">
                                Restaurant Address
                            </label>
                            <input
                                    class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                    name="address"
                                    type="text"
                                    placeholder="Restaurant Address"
                            />
                        </div>
                        <div class="mb-4">
                            <label class="block mb-2 text-sm font-bold text-gray-700" for="description">
                                Description
                            </label>
                            <input
                                    class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                    name="description"
                                    type="text"
                                    placeholder="Description"
                            />
                        </div>
                        <div class="mb-4">
                            <label class="block mb-2 text-sm font-bold text-gray-700" for="facebook">
                                Facebook Link
                            </label>
                            <input
                                    class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                    name="facebook"
                                    type="text"
                                    placeholder="Facebook Url"
                            />
                        </div>
                        <div class="mb-4">
                            <label class="block mb-2 text-sm font-bold text-gray-700" for="location">
                                Location Link
                            </label>
                            <input
                                    class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                                    name="location"
                                    type="text"
                                    placeholder="Location Url"
                            />
                        </div>
                        <div class="mb-10">
                            <label class="block mb-2 text-sm font-bold text-gray-700" for="image">
                                Restaurant Image
                            </label>
                            <span class="sr-only">Choose profile photo</span>
                            <input type="file" name="image"  class="block w-full text-sm text-gray-500
                  file:mr-4 file:py-2 file:px-4
                  file:rounded-full file:border-0
                  file:text-sm file:font-semibold
                  file:bg-sky-50 file:text-sky-700
                  hover:file:bg-sky-100
                "/>
                        </div>
                        <div class=" text-center">
                            <input
                                    class="w-full px-4 py-2 font-bold text-white bg-blue-500 rounded-full hover:bg-blue-700 focus:outline-none focus:shadow-outline"
                                    type="submit"
                                    value="Register Restaurant"
                            />
                        </div>
                    </form>
                </div>

                <svg xmlns="http://www.w3.org/2000/svg" id="modal-close" class=" cursor-pointer relative right-9 h-9 text-red-400" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z" clip-rule="evenodd" />
                </svg>
            </div>
        </div>
    </div>
    <section class="mt-12 border-t-2 border-gray-300 max-w-6xl mx-auto px-4 sm:px-6 lg:px-4 py-8">
        <div class="text-center pb-12">
            <h2 class="text-xl font-bold text-sky-600">
                We have the best restaurants in the city
            </h2>
            <h1 class="font-bold text-3xl md:text-4xl lg:text-5xl font-heading text-gray-900">
                Check our restaurants in Rabat
            </h1>
        </div>
        <div class="grid grid-cols-1 lg:grid-cols-2 gap-6">
            <%
                RestaurantDaoImp restaurantDao = new RestaurantDaoImp();
                List <Restaurant> restaurantList = restaurantDao.getAllRestaurants();
                if (restaurantList!=null){
                    for(int i=0;i<restaurantList.size();i++){
            %>
            <div class="w-full bg-white rounded-lg sahdow-lg overflow-hidden flex flex-col md:flex-row">
                <div class="w-full md:w-2/5 h-80">
                    <img class="object-center object-cover w-full h-full"
                        src=<%="img/"+Paths.get(restaurantList.get(i).getImage()).getFileName().toString()%> />

                </div>
                <div class="w-full md:w-3/5 text-left p-6 md:p-4">
                    <p class="mt-2 text-xl text-gray-700 font-bold"><%=restaurantList.get(i).getName()%></p>
                    <p class="mt-2 text-base text-gray-400 font-normal"><%=restaurantList.get(i).getAddress()%></p>
                    <p class="mt-2 text-base leading-relaxed text-gray-500 font-normal"><%=restaurantList.get(i).getDescription()%></p>
                    <div class="mt-2 flex justify-start space-x-2">
                        <a href=<%=restaurantList.get(i).getFacebookUrl()%> target="_blank" rel="noopener noreferrer" class="text-gray-500 hover:text-gray-600">
                            <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 24 24">
                                <path fill-rule="evenodd" d="M22 12c0-5.523-4.477-10-10-10S2 6.477 2 12c0 4.991 3.657 9.128 8.438 9.878v-6.987h-2.54V12h2.54V9.797c0-2.506 1.492-3.89 3.777-3.89 1.094 0 2.238.195 2.238.195v2.46h-1.26c-1.243 0-1.63.771-1.63 1.562V12h2.773l-.443 2.89h-2.33v6.988C18.343 21.128 22 16.991 22 12z" clip-rule="evenodd"></path>
                            </svg>
                        </a>
                        <a href=<%=restaurantList.get(i).getLocationUrl()%> target="_blank" rel="noopener noreferrer" class="text-gray-500 hover:text-gray-600">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" viewBox="0 0 20 20" fill="currentColor">
                              <path fill-rule="evenodd" d="M5.05 4.05a7 7 0 119.9 9.9L10 18.9l-4.95-4.95a7 7 0 010-9.9zM10 11a2 2 0 100-4 2 2 0 000 4z" clip-rule="evenodd" />
                            </svg>
                        </a>
                    </div>
                    <div class="flex mt-10">
                        <button class="py-2 px-6 shadow-md rounded-full bg-orange-400 text-white font-sans font-semibold text-md  active:shadow-none mr-2">Edit</button>
                        <form action="DeleteRestaurant" method="post">
                            <input type="hidden" name="id" value="<%= restaurantList.get(i).getId() %>">
                            <button class="py-2 px-6 shadow-md rounded-full bg-red-500 text-white font-sans font-semibold text-md  active:shadow-none">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </section>
</div>
<script type="text/javascript" src="script/script.js" >
</script></body>
</html>