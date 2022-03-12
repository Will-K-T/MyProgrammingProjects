import requests
from bs4 import BeautifulSoup as bs
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver import DesiredCapabilities
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.keys import Keys
import time

# Webpage to be scraped
# URL = "https://www.python.org/"
URL = "https://www.bestbuy.com/site/samsung-3-3-usb-type-c-to-usb-type-c-charge-and-sync-cable-black/6364519.p?skuId=6364519"
# URL = "https://www.bestbuy.com/site/pny-geforce-rtx-3070-8gb-xlr8-gaming-epic-x-rgb-triple-fan-graphics-card/6432653.p?skuId=6432653"

"""
Setting up the webdriver to interact with the webpage (selenium)
"""

option = webdriver.ChromeOptions()
chrome_prefs = {}
option.experimental_options["prefs"] = chrome_prefs
option.add_argument("--window-size=0,0")
chrome_prefs["profile.default_content_settings"] = {"images": 2}
chrome_prefs["profile.managed_default_content_settings"] = {"images": 2}

# Starting the Chrome webdriver
driver = webdriver.Chrome("C:\\Users\\21wil\\Documents\\GitHub\\MyProgrammingProjects\\Python\\Libs\\chromedriver.exe", options=option)
driver.get(URL)

print("Chrome initialized")

"""
Setting up BeautifulSoup (web scraper)
"""

# Headers for the different browser types
headers = {'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) '
                         'AppleWebKit/537.36 (KHTML, like Gecko) '
                         'Chrome/75.0.3770.80 Safari/537.36'}

# Accessing the webpage through BeautifulSoup
page = requests.get(URL, headers=headers)

# Getting the html
soup = bs(page.content, "html.parser")

# print(soup.prettify())

# buy_button = soup.find("div", class_="fulfillment-add-to-cart-button")
# Getting the buy button
buy_button = soup.find("button", class_="btn btn-primary btn-lg btn-block btn-leading-ficon add-to-cart-button")

# Checking if the item is in stock or not
# print(buy_button.text if buy_button is not None else "Out of stock")

time.sleep(3)

while(True):
    add_to_cart = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.XPATH, "//*[@id=\"fulfillment-add-to-cart-button-fa3ace6c-276c-4b18-83df-bf01142724f3\"]/div/div/div/button")))
    print("added")
    # add_to_cart.click()
    # go_to_cart = None
    # try:
    #     go_to_cart = WebDriverWait(driver, .1).until(EC.presence_of_element_located((By.LINK_TEXT, "Go to Cart")))
    # except TimeoutException as ex:
    #     driver.quit()
    # if go_to_cart is not None:
    #     go_to_cart.click()
    driver.refresh()
    time.sleep(1)

# while True:
#     time.sleep(3)
#     driver.refresh()
